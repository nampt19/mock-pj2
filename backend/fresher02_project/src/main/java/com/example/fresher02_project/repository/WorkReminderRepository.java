package com.example.fresher02_project.repository;

import com.example.fresher02_project.model.WorkReminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkReminderRepository extends JpaRepository<WorkReminder,Integer> {
    List<WorkReminder> findByIdCustomer(int idCustomer);
    WorkReminder findByIdReminder(int idReminder);
    void delete(WorkReminder workReminder);

}
