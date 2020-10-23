package com.example.fresher02_project.domain.response;

import com.example.fresher02_project.model.Group;
import com.example.fresher02_project.model.User;

public class UserProfileResponse extends BaseResponse{
    User user;
    Group group;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
