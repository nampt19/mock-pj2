package com.example.fresher02_project.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "action")
public class Action implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAction;

    @Column(name = "name")
    private String name;

    public Action() {

    }

    public int getIdAction() {
        return idAction;
    }

    public void setIdAction(int idAction) {
        this.idAction = idAction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Action(int idAction, String name) {
        this.idAction = idAction;
        this.name = name;
    }
}
