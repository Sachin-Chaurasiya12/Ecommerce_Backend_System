package com.example.EcommBackend.dto;

public class RequestCategory {
    private String name;
    private String description;

    public RequestCategory(){}

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
