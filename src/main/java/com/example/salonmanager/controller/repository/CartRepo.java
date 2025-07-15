package com.example.salonmanager.repository;

import com.example.salonmanager.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepo extends JpaRepository<Cart, Integer> {

    Optional<Cart> findCartByCustomerId(Integer id);
}
