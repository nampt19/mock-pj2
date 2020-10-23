package com.example.fresher02_project.controller;

import com.example.fresher02_project.domain.response.GroupListResponse;
import com.example.fresher02_project.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/group")
public class RestGroupController {
    @Autowired
    private GroupService groupService;

    @CrossOrigin(origins = "*")
    @GetMapping("/groupList")
    public ResponseEntity<GroupListResponse> getAll(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(groupService.getAll(token));
    }
}
