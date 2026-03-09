package com.example.EcommBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.EcommBackend.dto.RegisterRequest;
import com.example.EcommBackend.dto.RegisterResponseDTO;
import com.example.EcommBackend.model.Users;
import com.example.EcommBackend.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    
    public RegisterResponseDTO register(RegisterRequest dto){
        Users user = new Users();
        user.setUsername(dto.getUsername());
        user.setPassword(encoder.encode(dto.getPassword()));
        repo.save(user);

        return new RegisterResponseDTO(
            user.getId(),
            user.getUsername()
        );
    }
    
}