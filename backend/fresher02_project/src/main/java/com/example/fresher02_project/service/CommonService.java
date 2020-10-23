package com.example.fresher02_project.service;

import com.example.fresher02_project.domain.request.ConfigPasswordRequest;

import com.example.fresher02_project.model.User;
import com.example.fresher02_project.model.UserRole;
import com.example.fresher02_project.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommonService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PageRepository pageRepository;

    @Autowired
    ActionRepository actionRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    RolePageActionRepository rolePageActionRepository;


    ConfigPasswordRequest configPassword =new ConfigPasswordRequest();

    public boolean checkToken(String token, String url, String action) {
        token = token.replace("Bearer ", "");
        if (token=="" || token == null) return false;
        User user = userRepository.findByToken(token);
        if (user == null ) return false;

        boolean found = false;
        int idPage = pageRepository.findByUrl(url).getIdPage();
        int idAction = actionRepository.findByName(action).getIdAction();
        int userId = user.getIdUser();
        List<UserRole> roleList = userRoleRepository.findByIdUser(userId);
        for (UserRole userRole : roleList) {
            if (rolePageActionRepository.findByIdRoleAndIdPageAndIdAction(userRole.getIdRole(), idPage, idAction) != null) {
                found = true;
                break;
            }
        }
        return found;
    }

    public boolean checkBaseToken(String token) {
        token = token.replace("Bearer ", "");
        if (token=="" || token == null) return false;
        User user = userRepository.findByToken(token);
        if (user == null ) return false;

        return true;
    }

}

