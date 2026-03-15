package com.example.EcommBackend.dto;

import java.util.List;

import com.example.EcommBackend.model.OrderItem;

public class OrderRequestDTO {
    private Integer userId;
    private String shippingAddress;
    private List<OrderItemRequestDTO> items;

    public OrderRequestDTO(){}

    public List<OrderItemRequestDTO> getItems() {
        return items;
    }
    public void setItems(List<OrderItemRequestDTO> items) {
        this.items = items;
    }
    public String getShippingAddress() {
        return shippingAddress;
    }
    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
