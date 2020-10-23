package com.example.fresher02_project.domain.response;

import com.example.fresher02_project.model.Role;

public class RoleResponse extends BaseResponse {
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
