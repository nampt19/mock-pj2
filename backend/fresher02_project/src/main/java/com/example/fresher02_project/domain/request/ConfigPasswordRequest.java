package com.example.fresher02_project.domain.request;

import java.io.Serializable;

public class ConfigPasswordRequest implements Serializable {

    private static final long serialVersionUID = 2L;

    private String newPassword;

    private String oldPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

}
