package com.example.salonmanager.service.manager;

import com.example.salonmanager.dto.ManagerDTO;
import com.example.salonmanager.entity.Manager;
import com.example.salonmanager.entity.Role;
import com.example.salonmanager.repository.ManagerRepo;
import com.example.salonmanager.repository.RoleRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ManagerServiceImpl implements ManagerService {
    private final ManagerRepo managerRepo;
    private final RoleRepo roleRepo;
    private PasswordEncoder encoder;
    @Override
    public void createManager(ManagerDTO managerDTO, Integer roleId) {
        try{
            Set<Role> roles = roleRepo.findById(roleId).stream().collect(Collectors.toSet());
            if (roles.isEmpty()){
                throw new IllegalAccessException("No roles specified.");
            } else {
                Manager manager = Manager.builder()
                        .fullName(managerDTO.getFullName())
                        .useName(managerDTO.getUseName())
                        .password(encoder.encode(managerDTO.getPassword()))
                        .roles(roles)
                        .build();

                managerRepo.save(manager);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
