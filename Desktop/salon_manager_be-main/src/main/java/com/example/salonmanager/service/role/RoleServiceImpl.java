package com.example.salonmanager.service.role;

import com.example.salonmanager.dto.RoleDTO;
import com.example.salonmanager.entity.Role;
import com.example.salonmanager.repository.RoleRepo;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService{
    private RoleRepo roleRepo;

    @Override
    public void createRole(RoleDTO roleDTO) {
        Role role = Role.builder()
                .name(roleDTO.getName())
                .build();
        roleRepo.save(role);
    }

}

