package com.example.EcommBackend.dto;

import java.time.LocalDateTime;
import java.util.List;


public class OrderResponseDTO {
    private Long Orderid;

    private LocalDateTime orderdate;
    private Double totalamount;
    private String status;
    private String shippingAddress;
    private List<OrderItemResponseDTO> items;

    public OrderResponseDTO(){}

    public List<OrderItemResponseDTO> getItems() {
        return items;
    }
    public void setItems(List<OrderItemResponseDTO> items) {
        this.items = items;
    }
    public void setOrderdate(LocalDateTime orderdate) {
        this.orderdate = orderdate;
    }
    public LocalDateTime getOrderdate() {
        return orderdate;
    }
    public void setOrderid(Long orderid) {
        Orderid = orderid;
    }
    public Long getOrderid() {
        return Orderid;
    }
    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    public String getShippingAddress() {
        return shippingAddress;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
    public void setTotalamount(Double totalamount) {
        this.totalamount = totalamount;
    }
    public Double getTotalamount() {
        return totalamount;
    }
}
