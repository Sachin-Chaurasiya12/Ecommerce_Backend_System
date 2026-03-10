package com.example.EcommBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EcommBackend.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long>{
    
}
