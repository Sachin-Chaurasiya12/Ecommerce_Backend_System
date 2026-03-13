package com.example.EcommBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EcommBackend.model.CartItem;

@Repository
public interface CartItemsRepo extends JpaRepository<CartItem,Long>{
    
}
