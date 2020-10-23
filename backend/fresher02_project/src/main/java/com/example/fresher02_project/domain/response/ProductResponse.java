package com.example.fresher02_project.domain.response;

import com.example.fresher02_project.model.Product;

public class ProductResponse extends BaseResponse{
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
