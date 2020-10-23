package com.example.fresher02_project.domain.response;

import com.example.fresher02_project.model.Group;

public class GroupResponse extends BaseResponse {
    Group group;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
