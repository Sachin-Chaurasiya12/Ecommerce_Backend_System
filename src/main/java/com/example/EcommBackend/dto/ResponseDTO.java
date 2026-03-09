package com.example.EcommBackend.dto;

public class ResponseDTO {
    private int id;
    private String username;

    public ResponseDTO(int id,String username){
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
