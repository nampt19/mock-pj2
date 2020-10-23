package com.example.fresher02_project.controller;

import com.example.fresher02_project.domain.request.SaveRoleRequest;
import com.example.fresher02_project.domain.response.*;
import com.example.fresher02_project.model.Role;
import com.example.fresher02_project.model.RolePageAction;
import com.example.fresher02_project.model.UserRole;
import com.example.fresher02_project.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/role")
public class RestRoleController {


    @Autowired
    private RoleService roleService;


//    @Autowired
//    private UserRoleService userRoleService;
//
//    @Autowired
//    private RolePageActionService rolePageActionService;

    //role
    @CrossOrigin(origins = "*")
    @GetMapping("/roleList")
    public ResponseEntity<RoleListResponse> getAllRole(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(roleService.getAllRole(token));
    }
    

    @CrossOrigin(origins = "*")
    @PostMapping("/saveRole")
    public ResponseEntity<RoleResponse> saveRole(@RequestHeader("Authorization") String token,@RequestBody SaveRoleRequest saveRoleRequest) {
        return ResponseEntity.ok(roleService.saveRole(token,saveRoleRequest));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/deleteRole/{idRole}")
    public ResponseEntity<BaseResponse> deleteRole(@RequestHeader("Authorization") String token,@PathVariable int idRole) {
        return ResponseEntity.ok(roleService.deleteRole(token,idRole));
    }

    //    userRole
    @CrossOrigin(origins = "*")
    @PostMapping("/saveUserRoleList")
    public ResponseEntity<UserRoleListResponse> saveUserRoleList(@RequestHeader("Authorization") String token,@RequestBody List<UserRole> userRoleList) {
        return ResponseEntity.ok(roleService.saveUserRoleList(token,userRoleList));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/deleteUserRoleList/{idUser}")
    public ResponseEntity<BaseResponse> deleteUserRoleList(@RequestHeader("Authorization") String token,@PathVariable int idUser) {
        return ResponseEntity.ok(roleService.deleteUserRoleList(token,idUser));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/getUserRoleList/{idUser}")
    public ResponseEntity<UserRoleListResponse> getUserRoleList(@RequestHeader("Authorization") String token,@PathVariable int idUser) {
        return ResponseEntity.ok(roleService.getUserRoleList(token,idUser));
    }

    //    rolePageAction
    @CrossOrigin(origins = "*")
    @PostMapping("/saveRolePageAction")
    public ResponseEntity<RolePageListActionResponse> saveRolePageaction(@RequestHeader("Authorization") String token,@RequestBody List<RolePageAction> rolePageActionList) {
        return ResponseEntity.ok(roleService.saveRolePageListAction(token,rolePageActionList));
    }



    @CrossOrigin(origins = "*")
    @DeleteMapping("/deleteRolePageAction/{idRole}")
    public ResponseEntity<BaseResponse> deleteRolePageaction(@RequestHeader("Authorization") String token,@PathVariable int idRole) {
        return ResponseEntity.ok(roleService.deleteRolePageListAction(token,idRole));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getRolePageAction/{idRole}")
    public ResponseEntity<RolePageListActionResponse> getRolePageActionByIdRole(@RequestHeader("Authorization") String token,@PathVariable int idRole) {
        return ResponseEntity.ok(roleService.getRolePageAction(token,idRole));
    }


}


