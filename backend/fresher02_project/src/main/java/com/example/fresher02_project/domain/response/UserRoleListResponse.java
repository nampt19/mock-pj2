package com.example.fresher02_project.domain.response;

import com.example.fresher02_project.model.UserRole;

import java.util.List;

public class UserRoleListResponse extends BaseResponse {
    List<UserRole> userRoleList;

    public List<UserRole> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<UserRole> userRoleList) {
        this.userRoleList = userRoleList;
    }
}
