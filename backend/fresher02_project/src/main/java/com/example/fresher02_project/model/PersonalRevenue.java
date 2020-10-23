package com.example.fresher02_project.model;

public class PersonalRevenue {
    private User user;
    private long revenue;

    public PersonalRevenue() {
    }

    ;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getRevenue() {
        return revenue;
    }

    public void setRevenue(long revenue) {
        this.revenue = revenue;
    }
}
