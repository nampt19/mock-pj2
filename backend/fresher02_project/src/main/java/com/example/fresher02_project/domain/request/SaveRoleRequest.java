package com.example.fresher02_project.domain.request;

import com.example.fresher02_project.model.PageAction;
import com.example.fresher02_project.model.Role;
import com.example.fresher02_project.model.RolePageAction;

import java.util.List;

public class SaveRoleRequest {
    Role role;

    List<RolePageAction> rolePageActionList;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<RolePageAction> getRolePageActionList() {
        return rolePageActionList;
    }

    public void setRolePageActionList(List<RolePageAction> rolePageActionList) {
        this.rolePageActionList = rolePageActionList;
    }
}
