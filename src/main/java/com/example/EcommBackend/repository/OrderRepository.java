package com.example.EcommBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EcommBackend.model.Orders;

public interface OrderRepository extends JpaRepository<Orders,Long>{
    
}
