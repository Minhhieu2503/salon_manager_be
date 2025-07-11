package com.example.salonmanager.repository;

import com.example.salonmanager.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ManagerRepo extends JpaRepository<Manager, Integer> {
    Optional<Manager> findManagerByUseName(String useName);
}
