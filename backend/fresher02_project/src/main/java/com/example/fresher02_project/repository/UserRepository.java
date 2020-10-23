package com.example.fresher02_project.repository;

import com.example.fresher02_project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User,Integer> {
    User findByIdUser(int id);
    User findByEmail(String email);
    User findByToken(String token);
    User findByUsername(String username);
    User findByPhone(String phone);
    List<User> findAll();
    List<User> findByIdGroup(Integer id);

}
