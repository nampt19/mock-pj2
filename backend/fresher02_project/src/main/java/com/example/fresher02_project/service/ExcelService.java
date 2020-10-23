package com.example.fresher02_project.service;

import com.example.fresher02_project.helper.ExcelHelper;
import com.example.fresher02_project.model.*;
import com.example.fresher02_project.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.List;


@Service
public class ExcelService extends CommonService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    HistoryCareRepository historyCareRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    ProductRepository productRepository;

    public ByteArrayInputStream loadCustomer(String token) {
        if (checkToken(token, "customer.html", "read")) {
            List<Customer> customers = customerRepository.findAll();

            ByteArrayInputStream in = ExcelHelper.customerToExcel(customers);
            return in;
        }
        return null;
    }

    public ByteArrayInputStream loadUser(String token) {
        if (checkToken(token, "users.html", "read")) {
            List<User> users = userRepository.findAll();

            ByteArrayInputStream in = ExcelHelper.userToExcel(users);
            return in;
        }
        return null;
    }

    public ByteArrayInputStream loadHistoryCare(String token) {
        if (checkToken(token, "mycustomerhistorycare.html", "read")) {

            List<HistoryCare> historyCares = historyCareRepository.findAll();

            ByteArrayInputStream in = ExcelHelper.historyCareToExcel(historyCares);
            return in;
        }
        return null;
    }

    public ByteArrayInputStream loadTransection(String token) {
        if (checkToken(token, "transaction.html", "read")) {

            List<Transaction> transactions = transactionRepository.findAll();

            ByteArrayInputStream in = ExcelHelper.transactionToExcel(transactions);
            return in;
        }
        return null;
    }

    public ByteArrayInputStream loadProduct(String token) {
        if (checkToken(token, "products.html", "read")) {

            List<Product> products = productRepository.findAll();

            ByteArrayInputStream in = ExcelHelper.productToExcel(products);
            return in;
        }
        return null;
    }
}
