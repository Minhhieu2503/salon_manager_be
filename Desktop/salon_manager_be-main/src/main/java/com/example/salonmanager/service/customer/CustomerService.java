package com.example.salonmanager.service.customer;

import com.example.salonmanager.dto.CustomerDTO;
import com.example.salonmanager.exception.CustomerException;
import com.example.salonmanager.exception.LoginException;
import com.example.salonmanager.response.AccountManagementResponse;

import java.util.Set;

public interface CustomerService {
    void createCustomer(CustomerDTO customerDTO);

    CustomerDTO getInformationCustomer(String username) throws CustomerException;

    String updateProfileCustomer(CustomerDTO customerDTO) throws LoginException;

}