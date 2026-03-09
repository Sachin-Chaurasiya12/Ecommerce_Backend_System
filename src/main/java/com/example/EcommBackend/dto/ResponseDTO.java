package com.example.EcommBackend.dto;

public class ResponseDTO {
    private String username;
    private String password;

    public ResponseDTO(String username,String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
}
