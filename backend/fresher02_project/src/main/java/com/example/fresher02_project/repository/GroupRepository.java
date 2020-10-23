package com.example.fresher02_project.repository;

import com.example.fresher02_project.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group,Integer> {
   Group findByIdGroup(int idGroup);
}
