package com.example.fresher02_project.service;

import com.example.fresher02_project.domain.response.GroupListResponse;
import com.example.fresher02_project.domain.response.GroupResponse;
import com.example.fresher02_project.model.Group;
import com.example.fresher02_project.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService extends CommonService{
    @Autowired
    GroupRepository groupRepository;

    private String thisPage = "users.html";

    public GroupListResponse getAll(String token){
        GroupListResponse groupListResponse = new GroupListResponse();
        if (checkToken(token, thisPage, "read")) {
            List<Group> groups = groupRepository.findAll(Sort.by(Sort.Direction.ASC, "idGroup"));
            if (groups != null) {
                groupListResponse.setCode("200");
                groupListResponse.setMessage("Get list Group Success !");
                groupListResponse.setGroupList(groups);
            }
        }
        return groupListResponse;
    }

    public GroupResponse getGroupByIdGroup(String token, int idGroup){
        GroupResponse groupResponse= new GroupResponse();
        if (checkToken(token, thisPage, "")) {

            Group group = groupRepository.findByIdGroup(idGroup);
            if (group != null) {
                groupResponse.setCode("200");
                groupResponse.setMessage("Get Group Success !");
            }
        }
        return groupResponse;
    }

}
