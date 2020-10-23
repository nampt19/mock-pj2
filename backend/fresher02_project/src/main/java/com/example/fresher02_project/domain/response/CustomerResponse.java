package com.example.fresher02_project.domain.response;

import com.example.fresher02_project.model.Customer;

public class CustomerResponse extends BaseResponse{
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
