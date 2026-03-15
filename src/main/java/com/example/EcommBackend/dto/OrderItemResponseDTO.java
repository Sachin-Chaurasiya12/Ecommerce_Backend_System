package com.example.EcommBackend.dto;

public class OrderItemResponseDTO {
    private Long productId;
    public String productName;
    public Integer quentity;
    public Double price;

    public OrderItemResponseDTO(){}

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Integer getQuentity() {
        return quentity;
    }
    public void setQuentity(Integer quentity) {
        this.quentity = quentity;
    }
}
