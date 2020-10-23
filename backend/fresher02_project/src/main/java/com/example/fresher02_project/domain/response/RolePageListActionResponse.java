package com.example.fresher02_project.domain.response;

import com.example.fresher02_project.model.RolePageAction;

import java.util.List;

public class RolePageListActionResponse extends BaseResponse {
    private List<RolePageAction> rolePageActionList;

    public List<RolePageAction> getRolePageActionList() {
        return rolePageActionList;
    }

    public void setRolePageActionList(List<RolePageAction> rolePageActionList) {
        this.rolePageActionList = rolePageActionList;
    }
}
