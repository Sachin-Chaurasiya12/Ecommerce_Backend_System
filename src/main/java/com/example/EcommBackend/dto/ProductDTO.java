package com.example.EcommBackend.dto;

import java.time.LocalDateTime;

import com.example.EcommBackend.model.Category;

public class ProductDTO {
    private Long id;

    private String name;
    private String description;
    private Double price;
    private Category category;
    private LocalDateTime CreatedAt;
    private LocalDateTime UpdatedAt;

    public ProductDTO(){}

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Double getPrice() {
        return price;
    }
    public Category getCatogaryId() {
        return category;
    }
    public LocalDateTime getCreatedAt() {
        return CreatedAt;
    }
    public LocalDateTime getUpdatedAt() {
        return UpdatedAt;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        CreatedAt = createdAt;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        UpdatedAt = updatedAt;
    }
}
