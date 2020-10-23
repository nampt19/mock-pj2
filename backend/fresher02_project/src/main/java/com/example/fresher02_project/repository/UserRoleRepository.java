package com.example.fresher02_project.repository;

import com.example.fresher02_project.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {
        List<UserRole> findByIdRole(int idRole);
        List<UserRole> findByIdUser(int idUser);
        UserRole findByIdUserRole(int idUserRole);

}
