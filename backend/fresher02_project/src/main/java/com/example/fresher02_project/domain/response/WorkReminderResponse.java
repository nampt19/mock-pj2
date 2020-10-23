package com.example.fresher02_project.domain.response;

import com.example.fresher02_project.model.User;
import com.example.fresher02_project.model.WorkReminder;

public class WorkReminderResponse extends BaseResponse {
    WorkReminder workReminder;
    User user;
    public WorkReminder getWorkReminder() {
        return workReminder;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setWorkReminder(WorkReminder workReminder) {
        this.workReminder = workReminder;
    }
}
