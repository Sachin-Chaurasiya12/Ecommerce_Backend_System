package com.example.EcommBackend.dto;

import java.time.LocalDateTime;

import com.example.EcommBackend.model.Category;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ProductRequest {
    private Long id;

    private String name;
    private String description;
    private Double price;
    private Category category;
    private LocalDateTime CreatedAt;
    private LocalDateTime UpdatedAt;

    public ProductRequest(){}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Category getCatogaryId() {
        return category;
    }
    public void setCatogaryId(Category catogaryId) {
        this.category = catogaryId;
    }
    public LocalDateTime getCreatedAt() {
        return CreatedAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        CreatedAt = createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return UpdatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        UpdatedAt = updatedAt;
    }
}
