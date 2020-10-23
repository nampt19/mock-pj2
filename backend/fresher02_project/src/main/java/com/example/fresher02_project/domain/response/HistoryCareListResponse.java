package com.example.fresher02_project.domain.response;

import com.example.fresher02_project.model.Customer;
import com.example.fresher02_project.model.HistoryCare;
import com.example.fresher02_project.model.User;

import java.util.List;

public class HistoryCareListResponse extends BaseResponse {
    List<HistoryCare> historyCares;
    Customer customer;
    User user;
    public List<HistoryCare> getHistoryCares() {
        return historyCares;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setHistoryCares(List<HistoryCare> historyCares) {
        this.historyCares = historyCares;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
