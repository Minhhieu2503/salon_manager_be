package com.example.salonmanager.controller.maneger;

import com.example.salonmanager.exeption.CustomerException;
import com.example.salonmanager.request.TimeEmployeeRequest;
import com.example.salonmanager.service.time.TimeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class TimeManagementController {
    private final TimeService timeService;

    @GetMapping("/times")
    public ResponseEntity<?> getAllTimes() {
        return ResponseEntity.ok(timeService.findAllTimes());
    }

    @PostMapping("/addTime")
    public ResponseEntity<?> addTimeToEmployee(
            @RequestBody TimeEmployeeRequest request) {
        timeService.addTimeForEmployee(request.getTimeId(), request.getEmployeeId());
        return ResponseEntity.ok("Thành công");
    }

    @DeleteMapping("/removeTime")
    public ResponseEntity<?> removeTimeFromEmployee(
            @RequestBody TimeEmployeeRequest request) {
        timeService.removeTimeFromEmployee(request.getTimeId(), request.getEmployeeId());
        return ResponseEntity.ok("Thành công");
    }
}
