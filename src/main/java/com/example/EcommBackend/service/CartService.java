package com.example.EcommBackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.EcommBackend.Exceptions.ResourceNotFoundException;
import com.example.EcommBackend.dto.CartDTO;
import com.example.EcommBackend.dto.CartRequest;
import com.example.EcommBackend.model.Cart;
import com.example.EcommBackend.model.CartItem;
import com.example.EcommBackend.model.Product;
import com.example.EcommBackend.repository.CartRepository;
import com.example.EcommBackend.repository.ProductRepo;

@Service
public class CartService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CartRepository cartRepository;

    public CartDTO addCart(CartRequest cartRequest) {
        
        Cart cart = cartRepository.findByUserId(cartRequest.getUserId())
                .orElseGet(() -> {
                    Cart newcart = new Cart();
                    newcart.setUserId(cartRequest.getUserId());
                    return cartRepository.save(newcart);
                });
        
        Product product = productRepo.findById(cartRequest.getProductId())
                    .orElseThrow();

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(cartRequest.getQuantity());
        cartItem.setCart(cart);
        
        cart.getItems().add(cartItem);

        cartRepository.save(cart);
        
        CartDTO dto = new CartDTO(cart.getUserId(), product.getId(), cart.getItems());
            
        return dto;
    }

    public CartDTO Cart(Long userId) {
        Cart cart = cartRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User Cart not found!"));
        
        return new CartDTO(
            cart.getUserId(),
            null,
            cart.getItems()
        );
    }

    public ResponseEntity<String> removeCart(Long userId) {
        Cart cart = cartRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User Cart not found!"));
        
        cartRepository.delete(cart);

        return ResponseEntity.ok("User Cart deleted successfully");
    }
    
}
