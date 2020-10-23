package com.example.fresher02_project.model;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "role")
public class Role implements Serializable {

    private static final long serialVersionUID = 7L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRole;

    @Column(name = "name")
    private String name;


    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public Role(int idRole, String name) {
        this.idRole = idRole;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }
}

