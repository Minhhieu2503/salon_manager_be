package com.example.salonmanager.controller.employee;

import com.example.salonmanager.request.AddWorkDoneInOrderRequest;
import com.example.salonmanager.request.TotalPriceByEmployeeAndDayRequest;
import com.example.salonmanager.service.employee.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class TotalPriceByEmployeeAndDayController {
    private EmployeeService employeeService;

    @GetMapping("/totalSalary")
    public ResponseEntity<?> totalPriceByEmployeeAndDay(@RequestBody TotalPriceByEmployeeAndDayRequest request){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.totalPriceByEmployeeAndDay(request));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
