package com.example.fresher02_project.domain.response;


import com.example.fresher02_project.model.PageAction;
import com.example.fresher02_project.model.RolePageAction;
import com.example.fresher02_project.model.User;

import java.util.List;
import java.util.Map;
import java.util.Vector;

public class UserResponse extends BaseResponse {

    User user;

    List<PageAction> pageActionList;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<PageAction> getPageActionList() {
        return pageActionList;
    }

    public void setPageActionList(List<PageAction> pageActionList) {
        this.pageActionList = pageActionList;
    }

}

