package com.example.fresher02_project.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "page")
public class Page implements Serializable {

    private static final long serialVersionUID = 5L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPage;

    @Column(name = "url")
    private String url;

    @Column(name = "note")
    private String note;

    public Page() {
    }

    public int getIdPage() {
        return idPage;
    }

    public void setIdPage(int idPage) {
        this.idPage = idPage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

