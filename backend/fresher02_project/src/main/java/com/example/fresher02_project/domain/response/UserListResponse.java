package com.example.fresher02_project.domain.response;

import com.example.fresher02_project.model.User;

import java.util.List;

public class UserListResponse extends BaseResponse{
    private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
