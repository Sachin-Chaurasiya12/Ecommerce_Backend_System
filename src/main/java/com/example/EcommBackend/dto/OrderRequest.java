package com.example.EcommBackend.dto;

import java.util.List;

public class OrderRequest {
    private Long userId;
    private String shippingAddress;
    private List<OrderItemDTO> items;

    public OrderRequest(){}

    public List<OrderItemDTO> getItems() {
        return items;
    }
    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }
    public String getShippingAddress() {
        return shippingAddress;
    }
    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
