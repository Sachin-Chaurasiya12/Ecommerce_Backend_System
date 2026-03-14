package com.example.EcommBackend.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.EcommBackend.Exceptions.ResourceNotFoundException;
import com.example.EcommBackend.dto.OrderDTO;
import com.example.EcommBackend.dto.OrderRequest;
import com.example.EcommBackend.model.Cart;
import com.example.EcommBackend.model.CartItem;
import com.example.EcommBackend.model.Order;
import com.example.EcommBackend.model.OrderItem;
import com.example.EcommBackend.repository.CartRepository;
import com.example.EcommBackend.repository.OrderRepo;

@Service
@Transactional
public class OrderService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrderRepo repo;

    public OrderDTO createOrder(OrderRequest request) {
        Cart cart = cartRepository.findByUserId(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Cart Not Found"));
        if(cart.getItems().isEmpty()){
            throw new RuntimeException("Cart is empty");
        }

        Order order = new Order();
        order.setUserId(request.getUserId());
        order.setShippingaddress(request.getShippingaddress());
        order.setPayment(request.getPayment());
        order.setOrderedAt(LocalDateTime.now());

        List<OrderItem> orderItems = new ArrayList<>();
        double total = 0;

        for(CartItem item : cart.getItems()){
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(item.getProduct());
            orderItem.setOrder(order);
            orderItem.setQuantity(item.getQuantity());
            orderItem.setPrice(item.getProduct().getPrice());

            orderItem.setOrder(order);
            order.getItems().add(orderItem);

            total += item.getProduct().getPrice() * item.getQuantity();

            orderItems.add(orderItem);
        }

        order.setTotalprice(total);

        repo.save(order);
        cart.getItems().clear();
        cartRepository.save(cart);

        return new OrderDTO(order.getShippingaddress(), order.getTotalprice(), order.getItems());

    }
    
}
