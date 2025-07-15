package com.example.salonmanager.repository;

import com.example.salonmanager.entity.WorkDone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkDoneRepo extends JpaRepository<WorkDone, Integer> {
}
