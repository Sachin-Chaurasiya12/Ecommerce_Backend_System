package com.example.EcommBackend.dto;

public class RegisterResponseDTO {
    private int id;
    private String username;

    public RegisterResponseDTO(int id,String username){
        this.id=id;
        this.username = username;
    }

    public int getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
}
