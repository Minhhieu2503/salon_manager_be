package com.example.salonmanager.repository;

import com.example.salonmanager.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {
}

