package com.example.fresher02_project.domain.response;

import com.example.fresher02_project.model.Group;

import java.util.List;

public class GroupListResponse extends BaseResponse {
    private List<Group> groupList;

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }
}
