package com.example.salonmanager.controller.customer;

import com.example.salonmanager.dto.CustomerDTO;
import com.example.salonmanager.exception.LoginException;
import com.example.salonmanager.service.customer.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class UpdateProfileController {
    private final CustomerService customerService;

    @PutMapping("/update-profile")
    public ResponseEntity<?> updateProfileCustomer(@RequestBody CustomerDTO customerDTO) throws LoginException {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.updateProfileCustomer(customerDTO));
    }
}

