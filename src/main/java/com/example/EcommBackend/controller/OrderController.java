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
package com.example.EcommBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.EcommBackend.dto.OrderRequestDTO;
import com.example.EcommBackend.dto.OrderResponseDTO;
import com.example.EcommBackend.service.orders.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PreAuthorize("hasRole('USER')")
    @PostMapping
    public OrderResponseDTO order(@RequestBody OrderRequestDTO request){
        return service.createOrder(request);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<OrderResponseDTO> getorder(
        @RequestParam int page,
        @RequestParam int size
    ){
        return service.getOrders(size,page);
    }
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{orderid}")
    public ResponseEntity<OrderResponseDTO> getorderByid(@PathVariable Integer orderid){
        OrderResponseDTO responseDTO = service.getOrders(orderid);
        return ResponseEntity.ok(responseDTO);
    }
}   
