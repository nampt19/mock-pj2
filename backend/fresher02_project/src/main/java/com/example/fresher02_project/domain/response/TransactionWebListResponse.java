package com.example.fresher02_project.domain.response;

import com.example.fresher02_project.model.*;

import java.util.List;

public class TransactionWebListResponse extends BaseResponse{
    List<TransactionWeb> transactionWebList;

    List<Customer> customerList;
    List<User> userList;
    List<Product> productList;

    public List<TransactionWeb> getTransactionWebList() {
        return transactionWebList;
    }

    public void setTransactionWebList(List<TransactionWeb> transactionWebList) {
        this.transactionWebList = transactionWebList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
