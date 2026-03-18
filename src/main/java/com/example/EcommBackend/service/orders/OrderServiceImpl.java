/*
 Ecommerce Backend System Copyright (C) 2026 Sachin Chaurasiya
    This program comes with ABSOLUTELY NO WARRANTY; for details type `show w'.
    This is free software, and you are welcome to redistribute it
    under certain conditions; type `show c' for details.

The hypothetical commands `show w' and `show c' should show the appropriate
parts of the General Public License.  Of course, your program's commands
might be different; for a GUI interface, you would use an "about box".

  You should also get your employer (if you work as a programmer) or school,
if any, to sign a "copyright disclaimer" for the program, if necessary.
For more information on this, and how to apply and follow the GNU GPL, see
<https://www.gnu.org/licenses/>.

  The GNU General Public License does not permit incorporating your program
into proprietary programs.  If your program is a subroutine library, you
may consider it more useful to permit linking proprietary applications with
the library.  If this is what you want to do, use the GNU Lesser General
Public License instead of this License.  But first, please read
<https://www.gnu.org/licenses/why-not-lgpl.html>.
*/
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
    public List<OrderResponseDTO> getOrders(int page,int size) {
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
