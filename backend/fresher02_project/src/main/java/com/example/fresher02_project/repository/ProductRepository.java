package com.example.fresher02_project.repository;

import com.example.fresher02_project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findAll();
    Product findByIdProduct(int id);
    Product findByName(String s);

}
