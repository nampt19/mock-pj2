package com.example.fresher02_project.domain.response;

import com.example.fresher02_project.model.Transaction;

import java.util.List;

public class TransactionWebChartResponse extends BaseResponse{

    List<Integer> status;

    int sales[];

    public int[] getSales() {
        return sales;
    }

    public void setSales(int[] sales) {
        this.sales = sales;
    }

    public List<Integer> getStatus() {
        return status;
    }

    public void setStatus(List<Integer> status) {
        this.status = status;
    }

}
