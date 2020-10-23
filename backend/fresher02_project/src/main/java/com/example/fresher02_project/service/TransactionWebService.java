package com.example.fresher02_project.service;

import com.example.fresher02_project.domain.response.BaseResponse;
import com.example.fresher02_project.domain.response.TransactionWebChartResponse;
import com.example.fresher02_project.domain.response.ProductResponse;
import com.example.fresher02_project.domain.response.TransactionWebListResponse;
import com.example.fresher02_project.domain.response.TransactionWebResponse;
import com.example.fresher02_project.helper.TimeHelper;
import com.example.fresher02_project.model.Customer;
import com.example.fresher02_project.model.Product;
import com.example.fresher02_project.model.Transaction;
import com.example.fresher02_project.model.TransactionWeb;
import com.example.fresher02_project.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TransactionWebService extends CommonService{

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    private String thisPage = "transaction.html";

    public TransactionWebChartResponse getDataForChart(String token) {
        TransactionWebChartResponse transactionWebChartResponse = new TransactionWebChartResponse();
        if (checkBaseToken(token)) {
            int nowYear = (new TimeHelper().getDateTimeNow()).getYear();
            int nowMonth = (new TimeHelper().getDateTimeNow()).getMonth();
            List<Integer> status = new ArrayList<>();
            String statusArray[] = {"Đã thanh toán", "Đang thanh toán", "Đã hủy"};
            for (int i = 0; i < 3; i++) {
                int count = 0;
                for (Transaction transaction : transactionRepository.findByStatus(statusArray[i])) {
                    if (transaction.getTransactionTime().getYear() == nowYear && transaction.getTransactionTime().getMonth() == nowMonth) {
                        count++;
                    }
                }
                status.add(count);
            }

            transactionWebChartResponse.setStatus(status);

            int salesMonth[] = new int[12];
            for (Transaction transaction : transactionRepository.findByStatus("Đã thanh toán")) {
                if (transaction.getTransactionTime().getYear() == nowYear) {
                    salesMonth[transaction.getTransactionTime().getMonth()] += productRepository.findByIdProduct(transaction.getIdProduct()).getPrice();
                }
            }
            transactionWebChartResponse.setSales(salesMonth);
        }
        return transactionWebChartResponse;
    }

    public TransactionWebListResponse getAllTransaction(String token) {

        TransactionWebListResponse transactionWebListResponse = new TransactionWebListResponse();

        if (checkToken(token, thisPage, "read")) {
            List<TransactionWeb> transactionWebList = new ArrayList<>();
            List<Transaction> transactionList = transactionRepository.findAll();
            if (transactionList.isEmpty()) {
                transactionWebListResponse.setCode("001");
                transactionWebListResponse.setMessage("Transaction is Empty !!!");
            } else {
                transactionWebListResponse.setCode("000");
                transactionWebListResponse.setMessage("success");
                for (Transaction transaction : transactionList) {
                    int userId = transaction.getIdUser();
                    String userName = userRepository.findByIdUser(transaction.getIdUser()).getName();
                    String userEmail = userRepository.findByIdUser(transaction.getIdUser()).getEmail();
                    Product product = productRepository.findByIdProduct(transaction.getIdProduct());
                    Customer customer = customerRepository.findByIdCustomer(transaction.getIdCustomer());
                    transactionWebList.add(new TransactionWeb(userId, userName, userEmail, transaction, product, customer));
                }
                transactionWebListResponse.setTransactionWebList(transactionWebList);
                transactionWebListResponse.setUserList(userRepository.findAll());
                transactionWebListResponse.setCustomerList(customerRepository.findAll());
                transactionWebListResponse.setProductList(productRepository.findAll());
            }
        }
        return transactionWebListResponse;
    }

    public TransactionWebResponse saveTransaction(String token,Transaction transaction){
        TransactionWebResponse transactionWebResponse = new TransactionWebResponse();
        Transaction transactionFindById = transactionRepository.findByIdDeal(transaction.getIdDeal());
        TransactionWeb transactionWeb = new TransactionWeb();
        if(transactionFindById == null){
            if (checkToken(token, thisPage, "add")) {
                transaction.setTransactionTime(new TimeHelper().getDateTimeNow());
                transaction = transactionRepository.save(transaction);
            //    System.out.println(transaction.getIdDeal());

                transactionWeb.setIdUser(transaction.getIdUser());
                transactionWeb.setUserName(userRepository.findByIdUser(transaction.getIdUser()).getName());
                transactionWeb.setUserEmail(userRepository.findByIdUser(transaction.getIdUser()).getEmail());
                transactionWeb.setTransaction(transaction);
                transactionWeb.setProduct(productRepository.findByIdProduct(transaction.getIdProduct()));
                transactionWeb.setCustomer(customerRepository.findByIdCustomer(transaction.getIdCustomer()));
                transactionWebResponse.setCode("200");
                transactionWebResponse.setMessage("thêm thành công");
                transactionWebResponse.setTransactionWeb(transactionWeb);
            }
        }else {
            if (checkToken(token, thisPage, "edit")) {
                transactionWebResponse.setCode("201");
                transactionWebResponse.setMessage("sửa thành công");
                transaction.setTransactionTime(new TimeHelper().getDateTimeNow());
                transaction.setIdCustomer(transactionFindById.getIdCustomer());
                transaction.setIdProduct(transactionFindById.getIdProduct());
                transaction.setIdUser(transactionFindById.getIdUser());
                transactionRepository.save(transaction);
            }
        }
        return transactionWebResponse;

    }

    public BaseResponse deleteTransaction(String token,int idDeal) {
        BaseResponse baseResponse = new BaseResponse();
        if (checkToken(token, thisPage, "delete")) {
            transactionRepository.delete(transactionRepository.findByIdDeal(idDeal));
            baseResponse.setCode("000");
            baseResponse.setMessage("Xóa giao dịch thành công!");
        }
        return baseResponse;
    }

    public BaseResponse getTransactionByIdForEdit(String token, int idDeal) {
        BaseResponse baseResponse = new BaseResponse();
        if (checkToken(token, thisPage, "edit")) {
            if (transactionRepository.findByIdDeal(idDeal) == null) {
                baseResponse.setCode("101");
                baseResponse.setMessage("Transaction not Exist !");
            } else {
                baseResponse.setCode("102");
                baseResponse.setMessage("Success !");
            }
        }
        return baseResponse;
    }

}
