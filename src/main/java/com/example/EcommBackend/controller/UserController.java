package com.example.EcommBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EcommBackend.dto.RegisterRequest;
import com.example.EcommBackend.dto.ResponseDTO;
import com.example.EcommBackend.service.UserService;

@RestController
@RequestMapping("api/auth")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public ResponseDTO register(@RequestBody RegisterRequest regRequest){
        return service.register(regRequest);
    }
}
