package com.example.fresher02_project.domain.response;

import com.example.fresher02_project.model.TransactionWeb;

public class TransactionWebResponse extends BaseResponse{
    TransactionWeb transactionWeb;

    public TransactionWeb getTransactionWeb() {
        return transactionWeb;
    }

    public void setTransactionWeb(TransactionWeb transactionWeb) {
        this.transactionWeb = transactionWeb;
    }
}
