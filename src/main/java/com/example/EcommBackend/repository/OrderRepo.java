package com.example.EcommBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EcommBackend.model.Orders;

@Repository
public interface OrderRepo extends JpaRepository<Orders,Integer>{
    
}
