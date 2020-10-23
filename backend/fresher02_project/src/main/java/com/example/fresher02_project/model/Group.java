package com.example.fresher02_project.model;

import javax.persistence.*;

@Entity
@Table(name = "group_user")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGroup;

    @Column(name = "name")
    private String groupName;

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public String getgroupName() {
        return groupName;
    }

    public void setGroupName(String name) {
        this.groupName = name;
    }
}
