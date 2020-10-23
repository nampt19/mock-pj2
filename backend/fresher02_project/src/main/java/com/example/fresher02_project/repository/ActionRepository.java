package com.example.fresher02_project.repository;

import com.example.fresher02_project.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepository extends JpaRepository<Action, Integer> {
    Action findByIdAction(int actionId);
    Action findByName(String name);
}
