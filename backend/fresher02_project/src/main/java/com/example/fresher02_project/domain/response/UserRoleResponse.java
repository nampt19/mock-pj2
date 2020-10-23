package com.example.fresher02_project.domain.response;

import com.example.fresher02_project.model.UserRole;

public class UserRoleResponse extends BaseResponse {
    private UserRole userRole;

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
