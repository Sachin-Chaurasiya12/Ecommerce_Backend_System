package com.example.EcommBackend.dto;

import java.util.List;

import com.example.EcommBackend.model.Product;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "name", "description"})
public class CategoryDTO {

    private Long id;
    private String name;
    private String description;

    public CategoryDTO(){}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

