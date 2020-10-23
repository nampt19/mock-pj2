package com.example.fresher02_project.domain.response;

import com.example.fresher02_project.model.ProductAmount;

import java.util.List;

public class ProductAmountListResponse extends BaseResponse{
    private List<ProductAmount> productAmounts;

    public List<ProductAmount> getProductAmounts() {
        return productAmounts;
    }

    public void setProductAmounts(List<ProductAmount> productAmounts) {
        this.productAmounts = productAmounts;
    }
}
