package com.example.fresher02_project.domain.response;

import com.example.fresher02_project.model.Customer;
import com.example.fresher02_project.model.HistoryCare;
import com.example.fresher02_project.model.User;

public class HistoryCareResponse extends BaseResponse {
    HistoryCare historyCare;
    Customer customer;
    User user;

    public HistoryCare getHistoryCare() {
        return historyCare;
    }

    public void setHistoryCare(HistoryCare historyCare) {
        this.historyCare = historyCare;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
