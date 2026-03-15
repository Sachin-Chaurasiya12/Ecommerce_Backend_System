package com.example.EcommBackend.dto;

public class OrderItemDTO {
    private Long product;
    private int quantity;

    public OrderItemDTO(){}
    public Long getProduct() {
        return product;
    }
    public void setProduct(Long product) {
        this.product = product;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
