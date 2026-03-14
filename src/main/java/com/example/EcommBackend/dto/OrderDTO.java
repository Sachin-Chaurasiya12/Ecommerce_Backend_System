package com.example.EcommBackend.dto;

import java.util.List;

import com.example.EcommBackend.model.Order;
import com.example.EcommBackend.model.OrderItem;
import com.example.EcommBackend.model.Product;

public class OrderDTO {
    
    private String shippingaddress;
    private double price;
    private List<OrderItem> order;
    
    public OrderDTO(){}
    public OrderDTO(String shippingaddress, double price, List<OrderItem> order){
    this.shippingaddress = shippingaddress;
    this.price = price;
    this.order = order;
    }
    public String getShippingaddress() {
        return shippingaddress;
    }
    public void setShippingaddress(String shippingaddress) {
        this.shippingaddress = shippingaddress;
    }
    public List<OrderItem> getOrder() {
        return order;
    }
    public void setOrder(List<OrderItem> order) {
        this.order = order;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
