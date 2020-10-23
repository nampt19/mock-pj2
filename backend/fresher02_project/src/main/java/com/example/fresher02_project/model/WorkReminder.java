package com.example.fresher02_project.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "work_reminder")
public class WorkReminder implements Serializable {
    private static final String MY_TIME_ZONE="Asia/Ho_Chi_Minh";
    private static final long serialVersionUID = 97L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReminder;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "id_customer")
    private int idCustomer;

    @Column(name = "title")
    private String title;

    @Column(name = "create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone =MY_TIME_ZONE)
    private Date createTime;

    @Column(name = "content")
    private String content;

    @Column(name = "done")
    private int done;

    public WorkReminder() {
    }
    ;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getIdReminder() {
        return idReminder;
    }

    public void setIdReminder(int idReminder) {
        this.idReminder = idReminder;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getDone() {
        return done;
    }

    public void setDone(int done) {
        this.done = done;
    }
}
