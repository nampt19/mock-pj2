package com.example.fresher02_project.domain.response;

import com.example.fresher02_project.model.Role;

import java.util.List;

public class RoleListResponse extends BaseResponse{
    private List<Role> roleList;

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
