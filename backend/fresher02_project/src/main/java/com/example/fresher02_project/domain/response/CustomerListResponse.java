package com.example.fresher02_project.domain.response;

import com.example.fresher02_project.model.Customer;

import java.util.List;

public class CustomerListResponse extends BaseResponse {
    List<Customer> customerList ;

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
