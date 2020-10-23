package com.example.fresher02_project.repository;

import com.example.fresher02_project.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    Transaction findByIdDeal(int idDeal);
    List<Transaction> findAll();
    List<Transaction> findByStatusAndIdProduct(String s, int id);
    List<Transaction> findByStatus(String status);
    List<Transaction> findAllByStatus(String status);
    List<Transaction> findAllByStatusAndIdUser(String status, int idUser);
    List<Transaction> findByTransactionTimeBetween(Date start, Date end);
}
