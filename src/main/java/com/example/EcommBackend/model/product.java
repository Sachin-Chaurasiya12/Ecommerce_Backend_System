package com.example.EcommBackend.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="product_details")
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double price;
    @ManyToOne()
    @JoinColumn(name = "Category_id")
    private Category category;
    private LocalDateTime CreatedAt;
    private LocalDateTime UpdatedAt;

    public product(){}

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
