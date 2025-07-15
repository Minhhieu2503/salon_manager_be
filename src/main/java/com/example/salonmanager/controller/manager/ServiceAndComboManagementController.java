package com.example.salonmanager.controller.manager;

import com.example.salonmanager.exception.CustomerException;
import com.example.salonmanager.service.combo.ComboService;
import com.example.salonmanager.service.customer.CustomerService;
import com.example.salonmanager.service.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class ServiceAndComboManagementController {
    private final ProductService productService;
    private final ComboService comboService;

    @GetMapping("/services")
    public ResponseEntity<?> getAllServices() {
        return ResponseEntity.ok(productService.getAllServices());
    }

    @GetMapping("/combos")
    public ResponseEntity<?> getAllCombos() {
        return ResponseEntity.ok(comboService.getAllCombos());
    }
}
