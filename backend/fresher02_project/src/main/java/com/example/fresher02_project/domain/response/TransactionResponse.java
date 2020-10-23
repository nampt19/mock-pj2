package com.example.fresher02_project.domain.response;

import com.example.fresher02_project.model.Transaction;

public class TransactionResponse  extends  BaseResponse{
    private Transaction transaction;

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
