package com.example.fresher02_project.model;

public class ProductAmount {
    private Product product;
    private int amount;

    public ProductAmount(){}

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
