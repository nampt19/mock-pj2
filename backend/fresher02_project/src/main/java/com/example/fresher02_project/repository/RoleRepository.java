package com.example.fresher02_project.repository;

import com.example.fresher02_project.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface RoleRepository extends JpaRepository<Role, Integer> {
        Role findByIdRole( int idRole);
        Role findByName(String name);
}
