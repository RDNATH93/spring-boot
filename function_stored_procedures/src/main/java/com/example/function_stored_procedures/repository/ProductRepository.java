package com.example.function_stored_procedures.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.function_stored_procedures.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    
}
