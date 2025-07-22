package com.example.salonmanager.repository;

import com.example.salonmanager.entity.Customer;
import com.example.salonmanager.response.AccountManagementResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Set;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    @Query("select c from Customer c where c.userName = :username")
    Optional<Customer> findCustomerByUsername(@Param("username") String username);

    @Query("select c from Customer c where c.email = :email")
    Optional<Customer> findCustomerByEmail(@Param("email") String email);

}
