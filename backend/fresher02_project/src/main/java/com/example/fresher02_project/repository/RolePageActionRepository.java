package com.example.fresher02_project.repository;

import com.example.fresher02_project.model.RolePageAction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RolePageActionRepository extends JpaRepository<RolePageAction, Integer> {
    List<RolePageAction> findByIdRole(int idRole);
    RolePageAction findByIdRoleAndIdPageAndIdAction(int idRole, int idPage , int idAction);
}
