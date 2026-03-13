package com.example.EcommBackend.dto;

import java.util.List;
import com.example.EcommBackend.model.CartItem;
import com.fasterxml.jackson.annotation.JsonIgnoreType;


public class CartDTO {

    private Long userId;
    private Long productId;
    private List<CartItem> items;

    public CartDTO(){}

    public CartDTO(Long userId, Long productId, List<CartItem> items){
        this.userId = userId;
        this.productId = productId;
        this.items = items;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }
}
