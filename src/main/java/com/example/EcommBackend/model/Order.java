package com.example.EcommBackend.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Order")
public class Order {
    @Id
    private int id;
    private Long userId;
    private String shippingaddress;
    private String payment;
    private double totalprice;
    private LocalDateTime OrderedAt;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderItem> items;

    public Order(){}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public List<OrderItem> getItems() {
        return items;
    }
    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
    public LocalDateTime getOrderedAt() {
        return OrderedAt;
    }
    public void setOrderedAt(LocalDateTime orderedAt) {
        OrderedAt = orderedAt;
    }
    public String getPayment() {
        return payment;
    }
    public void setPayment(String payment) {
        this.payment = payment;
    }
    public String getShippingaddress() {
        return shippingaddress;
    }
    public void setShippingaddress(String shippingaddress) {
        this.shippingaddress = shippingaddress;
    }
    public double getTotalprice() {
        return totalprice;
    }
    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
