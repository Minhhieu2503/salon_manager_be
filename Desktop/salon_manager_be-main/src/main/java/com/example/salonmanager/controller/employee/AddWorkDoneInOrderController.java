package com.example.salonmanager.controller.employee;

import com.example.salonmanager.dto.OrderDTO;
import com.example.salonmanager.request.AddWorkDoneInOrderRequest;
import com.example.salonmanager.service.workdone.WorkDoneService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class AddWorkDoneInOrderController {
    private WorkDoneService workDoneService;

    @PostMapping("/addWork")
    public ResponseEntity<?> addWorkDoneInOrder(@RequestBody AddWorkDoneInOrderRequest request){
        try {
            String message = workDoneService.addWorkDoneInOrder(request);
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
