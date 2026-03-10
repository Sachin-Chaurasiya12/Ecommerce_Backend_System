package com.example.EcommBackend.dto;

public class ProductRequest {

    private String name;
    private String description;
    private Double price;
    private Long categoryId; // Use Long to capture the ID from the JSON

    public ProductRequest(){}

    // GETTERS
    public String getName() { return name; }
    public String getDescription() { return description; }
    public Double getPrice() { return price; }
    public Long getCategoryId() { return categoryId; } // Changed to Long

    // SETTERS
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setPrice(Double price) { this.price = price; }
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; } // Changed to Long
}