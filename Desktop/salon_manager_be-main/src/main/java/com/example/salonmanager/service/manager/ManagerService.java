package com.example.salonmanager.service.manager;

import com.example.salonmanager.dto.ManagerDTO;

public interface ManagerService {
    void createManager(ManagerDTO managerDTO, Integer roleId);
}
