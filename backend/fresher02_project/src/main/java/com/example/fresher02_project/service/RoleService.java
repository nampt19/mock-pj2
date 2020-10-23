package com.example.fresher02_project.service;

import com.example.fresher02_project.domain.request.SaveRoleRequest;
import com.example.fresher02_project.domain.response.*;
import com.example.fresher02_project.model.Role;
import com.example.fresher02_project.model.RolePageAction;
import com.example.fresher02_project.model.UserRole;
import com.example.fresher02_project.repository.RolePageActionRepository;
import com.example.fresher02_project.repository.RoleRepository;
import com.example.fresher02_project.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService extends CommonService {
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    RolePageActionRepository rolePageActionRepository;

    private String thisPage = "roles.html";

    //    role
    public RoleListResponse getAllRole(String token) {
        RoleListResponse roleListResponse = new RoleListResponse();
        if (checkToken(token, thisPage, "read") || checkToken(token, "users.html", "edit")) {
            List<Role> roleList = roleRepository.findAll(Sort.by(Sort.Direction.ASC, "idRole"));
            if (roleList != null) {
                roleListResponse.setCode("200");
                roleListResponse.setMessage("get All success !");
                roleListResponse.setRoleList(roleList);

            } else {
                roleListResponse.setCode("201");
                roleListResponse.setMessage("get All error!");
            }
        }
        return roleListResponse;
    }

    public RoleResponse saveRole(String token, SaveRoleRequest saveRoleRequest) {
        RoleResponse roleResponse = new RoleResponse();
        Role role = saveRoleRequest.getRole();
        int idRole = role.getIdRole();
        String nameRole = role.getName();
        if (idRole == -1) {
            if (checkToken(token, thisPage, "add")) {
                if (roleRepository.findByName(nameRole) != null) {
                    roleResponse.setCode("201");
                    roleResponse.setMessage("Tên quyền đã tồn tại !");
                } else {
                    roleRepository.save(new Role(nameRole));
                    role = roleRepository.findByName(nameRole);
                    for (RolePageAction rolePageAction : saveRoleRequest.getRolePageActionList()) {
                        rolePageActionRepository.save(new RolePageAction(role.getIdRole(), rolePageAction.getIdPage(), rolePageAction.getIdAction()));
                    }
                    roleResponse.setCode("000");
                    roleResponse.setMessage("Thêm quyền thành công !");
                    roleResponse.setRole(role);
                }
            }
        } else {
            if (checkToken(token, thisPage, "edit")) {
                role = roleRepository.findByIdRole(idRole);
                role.setName(nameRole);
                roleRepository.save(role);
                rolePageActionRepository.deleteAll(rolePageActionRepository.findByIdRole(idRole));
                rolePageActionRepository.saveAll(saveRoleRequest.getRolePageActionList());
                roleResponse.setCode("000");
                roleResponse.setMessage("Sửa quyền thành công !");
                roleResponse.setRole(role);
            }

        }

        return roleResponse;
    }

    public BaseResponse deleteRole(String token, int idRole) {
        BaseResponse baseResponse = new BaseResponse();

        if (checkToken(token, thisPage, "delete")) {
            if (!rolePageActionRepository.findByIdRole(idRole).isEmpty()) {
                rolePageActionRepository.deleteAll(rolePageActionRepository.findByIdRole(idRole));
            }
            if(!userRoleRepository.findByIdRole(idRole).isEmpty()){
                userRoleRepository.deleteAll(userRoleRepository.findByIdRole(idRole));
            }
            roleRepository.delete(roleRepository.findByIdRole(idRole));
            baseResponse.setCode("000");
            baseResponse.setMessage("Xóa quyền thành công!");
        }
        return baseResponse;
    }

//    userRole

    public UserRoleListResponse saveUserRoleList(String token, List<UserRole> userRoleList) {
        UserRoleListResponse userRoleListResponse = new UserRoleListResponse();
        List<UserRole> userRoleList1 = new ArrayList<>();
        for (UserRole userRole : userRoleList) {
            userRoleList1 = userRoleRepository.findByIdUser(userRole.getIdUser());
        }
        if (userRoleList1.isEmpty()) {
            if (checkToken(token, thisPage, "add") || checkToken(token, "users.html", "add")) {
                userRoleListResponse.setCode("200");
                userRoleListResponse.setMessage("Thêm UserRoleList thành công !");
                userRoleListResponse.setUserRoleList(userRoleList);
                userRoleRepository.saveAll(userRoleList);
            }
        } else {
            if (checkToken(token, thisPage, "edit") || checkToken(token, "users.html", "edit")) {
                userRoleRepository.deleteAll(userRoleList1);
                userRoleRepository.saveAll(userRoleList);
                userRoleListResponse.setCode("201");
                userRoleListResponse.setMessage("Sửa UserRoleList thành công !");
                userRoleListResponse.setUserRoleList(userRoleList);
            }
        }
        return userRoleListResponse;
    }

    //   xóa cùng lúc xóa nhân viên luôn lên không cần dùng !
    public BaseResponse deleteUserRoleList(String token, int idUser) {
        BaseResponse baseResponse = new BaseResponse();
        if (checkToken(token, thisPage, "delete")) {
            List<UserRole> userRoleList = userRoleRepository.findByIdUser(idUser);
            if (userRoleList.isEmpty()) {
                baseResponse.setCode("301");
                baseResponse.setMessage("Người dùng không tồn tại !");
            } else {
                baseResponse.setCode("300");
                baseResponse.setMessage("Xóa UserRole thành công");
                userRoleRepository.deleteAll(userRoleList);
            }
        }
        return baseResponse;
    }

    public UserRoleListResponse getUserRoleList(String token, int idUser) {
        UserRoleListResponse userRoleListResponse = new UserRoleListResponse();
        if (checkToken(token, thisPage, "read") || checkToken(token, "users.html", "edit")) {
            if (userRepository.findByIdUser(idUser) != null) {
                List<UserRole> userRoleList = userRoleRepository.findByIdUser(idUser);

                if (userRoleList.isEmpty()) {
                    userRoleListResponse.setCode("101");
                    userRoleListResponse.setMessage("null");
                } else {
                    userRoleListResponse.setCode("100");
                    userRoleListResponse.setMessage("success");
                    userRoleListResponse.setUserRoleList(userRoleList);
                }
            } else {
                userRoleListResponse.setCode("102");
                userRoleListResponse.setMessage("User not exist !");
            }
        }
        return userRoleListResponse;
    }

    //    rolePageAction
//    public List<RolePageAction> getAllRPA(String token) {
//        return rolePageActionRepository.findAll();
//    }

    public RolePageListActionResponse saveRolePageListAction(String token, List<RolePageAction> rolePageActionList) {
    //    System.out.println(rolePageActionList);
        RolePageListActionResponse rolePageListActionResponse = new RolePageListActionResponse();
        List<RolePageAction> rolePageActionList1 = new ArrayList<>();
        for (RolePageAction rolePageAction : rolePageActionList) {
            rolePageActionList1 = rolePageActionRepository.findByIdRole(rolePageAction.getIdRole());
        }
        if (rolePageActionList1.isEmpty()) {
            if (checkToken(token, thisPage, "add")) {
                rolePageListActionResponse.setCode("200");
                rolePageListActionResponse.setMessage("Thêm RPA thành công !");
                rolePageListActionResponse.setRolePageActionList(rolePageActionList);
                rolePageActionRepository.saveAll(rolePageActionList);
            }
        } else {
            if (checkToken(token, thisPage, "edit")) {
                rolePageActionRepository.deleteAll(rolePageActionList1);
                rolePageActionRepository.saveAll(rolePageActionList);
                rolePageListActionResponse.setCode("201");
                rolePageListActionResponse.setMessage("Sửa RPA thành công !");
                rolePageListActionResponse.setRolePageActionList(rolePageActionList);
            }
        }
        return rolePageListActionResponse;
    }


    public BaseResponse deleteRolePageListAction(String token, int idRole) {
        BaseResponse baseResponse = new BaseResponse();
        if (checkToken(token, thisPage, "deldete")) {
            List<RolePageAction> rolePageActionList = rolePageActionRepository.findByIdRole(idRole);
            if (rolePageActionList.isEmpty()) {
                baseResponse.setCode("301");
                baseResponse.setMessage("Quyền không tồn tại !");
            } else {
                baseResponse.setCode("300");
                baseResponse.setMessage("Xóa RPA thành công");
                rolePageActionRepository.deleteAll(rolePageActionList);
            }
        }
        return baseResponse;
    }

    public RolePageListActionResponse getRolePageAction(String token, int idRole) {
       // System.out.println(idRole);
        RolePageListActionResponse rolePageListActionResponse = new RolePageListActionResponse();
        if (checkToken(token, thisPage, "read")) {

            List<RolePageAction> rolePageActionList = rolePageActionRepository.findByIdRole(idRole);

            if (roleRepository.findByIdRole(idRole) == null) {
                rolePageListActionResponse.setCode("102");
                rolePageListActionResponse.setMessage("Role not exist !");
            }
            else if (rolePageActionList.isEmpty()) {
                rolePageListActionResponse.setCode("101");
                rolePageListActionResponse.setMessage("PageAction null");
            }else {
                rolePageListActionResponse.setCode("100");
                rolePageListActionResponse.setMessage("success");
                rolePageListActionResponse.setRolePageActionList(rolePageActionList);
            }
        }
        return rolePageListActionResponse;
    }
}
