package com.example.salonmanager.controller.customer;

import com.example.salonmanager.dto.CustomerDTO;
import com.example.salonmanager.exception.CustomerException;
import com.example.salonmanager.service.customer.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class GetInformationController {
    private final CustomerService customerService;

    @GetMapping("/info")
    public ResponseEntity<?> getCustomerInfo(@RequestParam String username) throws CustomerException {
        try {
            CustomerDTO customerInfo = customerService.getInformationCustomer(username);
            return ResponseEntity.ok(customerInfo);
        } catch (CustomerException ex) {
            throw ex;
        }
    }
}