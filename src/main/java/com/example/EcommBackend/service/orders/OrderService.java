package com.example.EcommBackend.service.orders;


import java.util.List;

import com.example.EcommBackend.dto.OrderRequestDTO;
import com.example.EcommBackend.dto.OrderResponseDTO;

public interface OrderService {
    OrderResponseDTO createOrder(OrderRequestDTO request);

    List<OrderResponseDTO> getOrders();

    OrderResponseDTO getOrders(Integer orderid);
}
