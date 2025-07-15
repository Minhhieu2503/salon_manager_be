package com.example.salonmanager.service.cart;

import com.example.salonmanager.exeption.CartItemException;
import com.example.salonmanager.exeption.ComboException;
import com.example.salonmanager.exeption.LoginException;
import com.example.salonmanager.request.AddComboInCartItemRequest;
import com.example.salonmanager.request.AddServiceInCartItemRequest;
import com.example.salonmanager.response.CartItemResponse;

import java.util.Set;

public interface CartService {
    String addCartItemInCartTypeCombo(AddComboInCartItemRequest request) throws CartItemException, ComboException, LoginException;

    String addCartItemInCartTypeService(AddServiceInCartItemRequest request) throws CartItemException, ComboException, LoginException;

    Set<CartItemResponse> getCartItem() throws LoginException;

    Integer countCartItem();

    void deleteCartItem(Set<Integer> cartItemIds);
}
