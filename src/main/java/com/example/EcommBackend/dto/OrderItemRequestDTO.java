package com.example.EcommBackend.dto;

public class OrderItemRequestDTO {

    private Long productId;
    private Integer quantity;

    public OrderItemRequestDTO(){}

    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuentity(Integer quentity) {
        this.quantity = quentity;
    }
    
}
