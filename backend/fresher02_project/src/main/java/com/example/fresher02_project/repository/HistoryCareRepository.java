package com.example.fresher02_project.repository;

import com.example.fresher02_project.model.HistoryCare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HistoryCareRepository extends JpaRepository<HistoryCare,Integer> {
    List<HistoryCare> findByIdCustomer(int idCustomer);
    List<HistoryCare> findAllByStartTimeAfter(int month);

}
