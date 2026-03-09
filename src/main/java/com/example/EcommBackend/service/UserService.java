package com.example.EcommBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.EcommBackend.dto.RegisterRequest;
import com.example.EcommBackend.dto.ResponseDTO;
import com.example.EcommBackend.dto.loginRequest;
import com.example.EcommBackend.model.Users;
import com.example.EcommBackend.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private JwtService jwtservice;

    @Autowired
    AuthenticationManager authManager;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    
    public ResponseDTO register(RegisterRequest dto){
        Users user = new Users();
        user.setUsername(dto.getUsername());
        user.setPassword(encoder.encode(dto.getPassword()));
        repo.save(user);

        return new ResponseDTO(
            user.getId(),
            user.getUsername()
        );
    }
    public String verify(loginRequest dto){
        Authentication authenticated = authManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                    dto.getUsername(),
                    dto.getPassword()
                ));
        if(authenticated.isAuthenticated()){
            return jwtservice.generateToken(dto.getUsername());
        }else{
            return "Login Failed";
        }
    }
    
}