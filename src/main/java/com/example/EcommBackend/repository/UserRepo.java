package com.example.EcommBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EcommBackend.model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer>{

    Users findByUsername(String username);
    
}
