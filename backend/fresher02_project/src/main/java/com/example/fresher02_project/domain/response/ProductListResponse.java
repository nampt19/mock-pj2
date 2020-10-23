package com.example.fresher02_project.domain.response;

import com.example.fresher02_project.model.Product;

import java.util.List;

public class ProductListResponse extends BaseResponse{
    private List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
