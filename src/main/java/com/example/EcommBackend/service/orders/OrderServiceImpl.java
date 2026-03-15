package com.example.EcommBackend.service.orders;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcommBackend.Exceptions.ResourceNotFoundException;
import com.example.EcommBackend.dto.OrderItemRequestDTO;
import com.example.EcommBackend.dto.OrderItemResponseDTO;
import com.example.EcommBackend.dto.OrderRequestDTO;
import com.example.EcommBackend.dto.OrderResponseDTO;
import com.example.EcommBackend.model.OrderItem;
import com.example.EcommBackend.model.Orders;
import com.example.EcommBackend.model.Product;
import com.example.EcommBackend.model.Users;
import com.example.EcommBackend.repository.OrderRepo;
import com.example.EcommBackend.repository.ProductRepo;
import com.example.EcommBackend.repository.UserRepo;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ProductRepo productRepo;
    @Override
    public OrderResponseDTO createOrder(OrderRequestDTO request) {
        Users user = userRepo.findById(request.getUserId())
                        .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Orders orders = new Orders();
        orders.setUser(user);
        orders.setOrderDate(LocalDateTime.now());
        orders.setShippingAddress(request.getShippingAddress());
        orders.setStatus("Created");

        double totalPrice = 0;

        List<OrderItem> items = new ArrayList<>();

        for(OrderItemRequestDTO itemDTO : request.getItems()){
            Product product = productRepo.findById(itemDTO.getProductId())
                            .orElseThrow(() -> new ResourceNotFoundException("Product Not found"));
            
            OrderItem item = new OrderItem();
            item.setOrder(orders);
            item.setProduct(product);
            item.setQuantity(itemDTO.getQuantity());
            item.setPrice(product.getPrice());

            totalPrice += product.getPrice() * itemDTO.getQuantity();

            items.add(item);
        }

        orders.setItems(items);
        orders.setTotalPrice(totalPrice);

        Orders savedorder = orderRepo.save(orders);

        return mapToResponse(savedorder);
        
    }
    private OrderResponseDTO mapToResponse(Orders order){

    OrderResponseDTO response = new OrderResponseDTO();

    response.setOrderId(order.getId());
    response.setOrderDate(order.getOrderDate());
    response.setShippingAddress(order.getShippingAddress());
    response.setStatus(order.getStatus());
    response.setTotalPrice(order.getTotalPrice());

    List<OrderItemResponseDTO> responseDTO = new ArrayList<>();

    for(OrderItem item : order.getItems()){
        OrderItemResponseDTO dto = new OrderItemResponseDTO();
        dto.setPrice(item.getPrice());
        dto.setProductId(item.getProduct().getId());
        dto.setProductName(item.getProduct().getName());
        dto.setQuantity(item.getQuantity());

        responseDTO.add(dto);
    }

    response.setItems(responseDTO);
    return response;
    }

    @Override
    public List<OrderResponseDTO> getOrders() {
        List<Orders> orders = orderRepo.findAll();

        List<OrderResponseDTO> dto = new ArrayList<>();

        for(Orders o : orders ){
            dto.add(mapToResponse(o));
        }
        return dto;
    }
    @Override
    public OrderResponseDTO getOrders(Integer orderid) {
        Orders orders = orderRepo.findById(orderid)
                    .orElseThrow(() -> new ResourceNotFoundException("order not found"));
        
        return mapToResponse(orders);
    }

}
