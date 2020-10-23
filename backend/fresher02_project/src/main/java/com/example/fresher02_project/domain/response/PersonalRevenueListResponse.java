package com.example.fresher02_project.domain.response;

import com.example.fresher02_project.model.PersonalRevenue;
import com.example.fresher02_project.model.User;

import java.util.List;
import java.util.Map;

public class PersonalRevenueListResponse extends BaseResponse{
  private List<PersonalRevenue>personalRevenueList;

    public List<PersonalRevenue> getPersonalRevenueList() {
        return personalRevenueList;
    }

    public void setPersonalRevenueList(List<PersonalRevenue> personalRevenueList) {
        this.personalRevenueList = personalRevenueList;
    }
}
