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
