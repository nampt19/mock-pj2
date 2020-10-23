package com.example.fresher02_project.model;

public class TransactionWeb{
    int idUser;
    String userName;
    String userEmail;
    Transaction transaction;
    Product product;
    Customer customer;

    public TransactionWeb() {
    }

    public TransactionWeb(int idUser, String userName, String userEmail, Transaction transaction, Product product, Customer customer) {
        this.idUser = idUser;
        this.userName = userName;
        this.userEmail = userEmail;
        this.transaction = transaction;
        this.product = product;
        this.customer = customer;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
