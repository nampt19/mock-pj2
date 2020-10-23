package com.example.fresher02_project.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDeal;

    @Column(name = "id_customer")
    private int idCustomer;

    @Column(name = "id_user")
    private int idUser;

    @Column(name = "transaction_time")
    private Date transactionTime;

    @Column(name = "id_product")
    private int idProduct;

    @Column(name = "status")
    private String status;

    @Column(name = "note")
    private String note;

    public Transaction() {

    }

    public Transaction(int idCustomer, int idUser, Date transactionTime, int idProduct, String status, String note) {
        this.idCustomer = idCustomer;
        this.idUser = idUser;
        this.transactionTime = transactionTime;
        this.idProduct = idProduct;
        this.status = status;
        this.note = note;
    }

    public int getIdDeal() {
        return idDeal;
    }

    public void setIdDeal(int idDeal) {
        this.idDeal = idDeal;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Date getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Date transactionTime) {
        this.transactionTime = transactionTime;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
