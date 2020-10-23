package com.example.fresher02_project.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "history_care")
public class HistoryCare implements Serializable {
    private static final String MY_TIME_ZONE="Asia/Ho_Chi_Minh";
    private static final long serialVersionUID = 4L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_customer")
    private int idCustomer;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "end_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone =MY_TIME_ZONE)
    private Date endTime;

    @Column(name = "start_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone =MY_TIME_ZONE)
    private Date startTime;

    @Column(name = "concern_level")
    private String concernLevel;

    @Column(name = "note")
    private String note;

    @Column(name = "potential_level")
    private String potentialLevel;

    @Column(name = "action")
    private String action;

    @Column(name = "method")
    private String method;

    @Column(name = "purpose")
    private String purpose;

    @Column(name = "product_name")
    private String productName;

    public HistoryCare() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getConcernLevel() {
        return concernLevel;
    }

    public void setConcernLevel(String concernLevel) {
        this.concernLevel = concernLevel;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPotentialLevel() {
        return potentialLevel;
    }

    public void setPotentialLevel(String potentialLevel) {
        this.potentialLevel = potentialLevel;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
