package com.example.fresher02_project.model;

import java.io.Serializable;
import java.util.List;

public class PageAction implements Serializable {
    private static final long serialVersionUID = 6L;

    Page page;

    List<Action> actionList;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<Action> getActionList() {
        return actionList;
    }

    public void setActionList(List<Action> actionList) {
        this.actionList = actionList;
    }
}
