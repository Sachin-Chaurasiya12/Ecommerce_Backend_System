package com.example.EcommBackend.dto;

public class OrderRequest {
    
    private Long userId;
    private String shippingAddress;
    private String payment;

    public OrderRequest(){}
    public OrderRequest(Long userId,String shippingAddress,String payment){
        this.userId = userId;
        this.shippingAddress = shippingAddress;
        this.payment = payment;
    }

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getPayment() {
        return payment;
    }
    public void setPayment(String payment) {
        this.payment = payment;
    }
    public String getShippingaddress() {
        return shippingAddress;
    }
    public void setShippingaddress(String shippingaddress) {
        this.shippingAddress = shippingaddress;
    }
}
