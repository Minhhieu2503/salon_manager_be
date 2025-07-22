package com.example.salonmanager.controller.customer;

import com.example.salonmanager.exception.LoginException;
import com.example.salonmanager.response.CartItemResponse;
import com.example.salonmanager.service.cart.CartService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class GetCartItemController {
    private final CartService cartService;

    @GetMapping("/cart-items")
    public ResponseEntity<?> getCartItems() {
        try {
            Set<CartItemResponse> cartItems = cartService.getCartItem();
            return ResponseEntity.ok(cartItems);
        } catch (LoginException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
}
