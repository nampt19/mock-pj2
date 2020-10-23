package com.example.fresher02_project.repository;

import com.example.fresher02_project.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    List<Customer> findAll();
    List<Customer> findByCreateByIdUser(int idUser);
    Customer findByIdCustomer(int id);
    Customer findByEmail(String email);
    Customer findByPhone(String phone);
}

