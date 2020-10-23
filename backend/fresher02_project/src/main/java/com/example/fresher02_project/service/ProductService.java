package com.example.fresher02_project.service;

import com.example.fresher02_project.domain.response.*;
import com.example.fresher02_project.model.Product;
import com.example.fresher02_project.model.ProductAmount;
import com.example.fresher02_project.model.Transaction;
import com.example.fresher02_project.repository.ProductRepository;
import com.example.fresher02_project.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService extends CommonService{
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    private String thisPage = "products.html";

    public ProductListResponse getAllProduct(String token) {
        ProductListResponse productListResponse = new ProductListResponse();
        if (checkToken(token, thisPage, "read")) {
            List<Product> productList = productRepository.findAll();
            if (productList != null) {
                productListResponse.setCode("200");
                productListResponse.setMessage("success");
                productListResponse.setProductList(productList);


            } else {
                productListResponse.setCode("201");
                productListResponse.setMessage("error");
            }
        }
        return productListResponse;
    }

    public ProductResponse saveProduct(String token,Product product){
        ProductResponse productResponse = new ProductResponse();
        Product product1 = productRepository.findByIdProduct(product.getIdProduct());
        if (product1 == null) {
            if (checkToken(token, thisPage, "add")) {
                if (productRepository.findByName(product.getName()) != null) {
                    productResponse.setCode("201");
                    productResponse.setMessage("Name already exists !");
                } else {
                    productResponse.setCode("200");
                    productResponse.setMessage("Insert Product success");
                    productResponse.setProduct(product);
                    productRepository.save(product);

                }
            }

        } else {
            if (checkToken(token, thisPage, "edit")) {
                productResponse.setCode("204");
                productResponse.setMessage("Edit Product success");
                productResponse.setProduct(product);
                productRepository.save(product);
            }
        }
        return productResponse;
    }

    public BaseResponse deleteProduct(String token,Integer id) {
        BaseResponse baseResponse = new BaseResponse();
        if (checkToken(token, thisPage, "delete")) {
            Product product = productRepository.findByIdProduct(id);
            if (product != null) {
                productRepository.delete(product);
                baseResponse.setCode("300");
                baseResponse.setMessage("Delete success !");
            } else {
                baseResponse.setCode("301");
                baseResponse.setMessage("Product Not Exist !");
            }
        }
        return  baseResponse;
    }


    public ProductAmountListResponse productSoldTheMost(String token) {
        ProductAmountListResponse productAmountListResponse= new ProductAmountListResponse();
        if (checkBaseToken(token)) {

            List<ProductAmount> productAmounts = new ArrayList<>();
            List<Product> productList = productRepository.findAll();
            List<Transaction> transactionList = transactionRepository.findAllByStatus("Đã thanh toán");

            for (Product product : productList) {
                int amount = 0;
                for (Transaction transaction : transactionList) {
                    if (product.getIdProduct() == transaction.getIdProduct() && (isLastMonth(transaction.getTransactionTime()))) {
                        amount += 1;
                    }
                }
                ProductAmount productAmount = new ProductAmount();
                productAmount.setProduct(product);
                productAmount.setAmount(amount);
                productAmounts.add(productAmount);
            }
            productAmountListResponse.setCode("200");
            productAmountListResponse.setMessage("success");
            productAmountListResponse.setProductAmounts(sortProductAmountList(productAmounts));
        }
        return productAmountListResponse;
    }

    public List<ProductAmount> sortProductAmountList(List<ProductAmount> productAmounts){
        ArrayList<Integer> amounts= new ArrayList<>();
        for (ProductAmount p:productAmounts) {
            if (!amounts.contains(p.getAmount())) {
                amounts.add(p.getAmount());
            }
        }
        Collections.sort(amounts);
        List<ProductAmount> sortedProductAmountList= new ArrayList<>();
        for(int i=amounts.size()-1;i>=0;i--){
            for (ProductAmount p:productAmounts) {
                if((amounts.get(i)==p.getAmount()) && (amounts.get(i)>0)){
                    sortedProductAmountList.add(p);
                 //   System.out.println(p.getProduct().getName()+": "+p.getAmount());
                }
            }
        }
        return sortedProductAmountList;
    }
    public boolean isLastMonth(Date date){
        Date currentDate= new Date();
        if((date.getMonth()==(currentDate.getMonth()-1)) &&(date.getYear()==currentDate.getYear())){
            return  true;
        }else {
            return false;
        }
    }

    public BaseResponse getProductByIdForEdit(String token, int idProduct) {
        BaseResponse baseResponse = new BaseResponse();
        if (checkToken(token, thisPage, "edit")) {
            if (productRepository.findByIdProduct(idProduct) == null) {

                baseResponse.setCode("101");
                baseResponse.setMessage("Product not Exist !");
            } else {
                baseResponse.setCode("102");
                baseResponse.setMessage("Success !");
            }
        }

        return baseResponse;
    }
}
