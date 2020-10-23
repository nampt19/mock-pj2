package com.example.fresher02_project.domain.response;

import com.example.fresher02_project.model.User;
import com.example.fresher02_project.model.WorkReminder;

import java.util.List;

public class WorkReminderListResponse extends BaseResponse {
    List<WorkReminder> workReminderList;
    User user;
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public List<WorkReminder> getWorkReminderList() {
        return workReminderList;
    }

    public void setWorkReminderList(List<WorkReminder> workReminderList) {
        this.workReminderList = workReminderList;
    }
}
