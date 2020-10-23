package com.example.fresher02_project.controller;

import com.example.fresher02_project.domain.request.ConfigPasswordRequest;
import com.example.fresher02_project.domain.response.*;
import com.example.fresher02_project.model.User;
import com.example.fresher02_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class RestUserController {

    @Autowired
    private UserService userService;


    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public ResponseEntity<UserResponse> checkLogin(@RequestBody User user) {

        return ResponseEntity.ok(userService.checkLogin(user));
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/logout")
    public ResponseEntity<UserResponse> logOut(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(userService.logOut(token));
    }

//    @CrossOrigin(origins = "*")
//    @GetMapping("/encryptpassword")
//    public List<User> encryptPassword() {
//        return userService.encryptPassword();
//    }
//
//    @CrossOrigin(origins = "*")
//    @GetMapping("/decryptpassword")
//    public List<User> decryptPassword() {
//        return userService.decryptPassword();
//    }

    @CrossOrigin(origins = "*")
    @PostMapping("/changepassword")
    public ResponseEntity<UserResponse> changePassword(@RequestHeader("Authorization") String token, @RequestBody ConfigPasswordRequest changePassword) {

        return ResponseEntity.ok(userService.changePassword(token, changePassword));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/resetpassword")
    public ResponseEntity<UserResponse> resetPassword(@RequestHeader("Authorization") String token, @RequestBody String agentId) {

        return ResponseEntity.ok(userService.resetPassword(token,agentId));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getAllUser")
    public ResponseEntity<UserListResponse> getAllUser(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(userService.getAllUser(token));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getAllUserExceptAdmin")
    public ResponseEntity<UserListResponse> getAllUserExceptAdmin(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(userService.getAllExceptAdmin(token));
    }


    @CrossOrigin(origins = "*")
    @RequestMapping("/getUserGroupInfo")
    public ResponseEntity<UserListResponse> getAllUserInMyGroupExceptMe(@RequestHeader("Authorization") String token,@RequestBody String idUser) {
        return ResponseEntity.ok(userService.getAllUserInMyGroup(token,idUser));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/saveUser")
    public ResponseEntity<UserResponse> saveUser(@RequestHeader("Authorization") String token,@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(token,user));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<BaseResponse> deleteUser(@RequestHeader("Authorization") String token,@PathVariable Integer id) {
        return ResponseEntity.ok(userService.deleteUser(token,id));
    }

////    chưa checkToken
//    @CrossOrigin(origins = "*")
//    @PostMapping("/findPassWordByIdUser/{id}")
//    public ResponseEntity<PasswordResponse> findPassWordByIdUser(@RequestHeader("Authorization") String token,@PathVariable Integer id) {
//        return ResponseEntity.ok(userService.findPassWordByIdUser(token,id));
//    }

    @CrossOrigin(origins = "*")
    @PostMapping("/getUserProfile")
    public ResponseEntity<BaseResponse> getUserProfile(@RequestHeader("Authorization") String token) {
        token = token.replace("Bearer ", "");
        return ResponseEntity.ok(userService.getUserProfile(token));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/editUserProfile")
    public ResponseEntity<BaseResponse> editUserProfile(@RequestHeader("Authorization") String token, @RequestBody User user) {
        token = token.replace("Bearer ", "");
        user.setToken(token);
        return ResponseEntity.ok(userService.editUserProfile(token,user));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getUsersWithMostRevenueLastMonth")
    public ResponseEntity<PersonalRevenueListResponse> getUsersWithMostRevenueLastMonth(@RequestHeader("Authorization") String token){
        return ResponseEntity.ok(userService.getUsersWithMostRevenue(token));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/checkTokenWeb")
    public ResponseEntity<BaseResponse> checkToken(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(userService.checkTokenWeb(token));
    }

}
