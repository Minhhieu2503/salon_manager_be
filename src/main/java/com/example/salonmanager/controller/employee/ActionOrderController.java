package com.example.salonmanager.controller.employee;

import com.example.salonmanager.request.ActionOrderByCustomerRequest;
import com.example.salonmanager.request.AddWorkDoneInOrderRequest;
import com.example.salonmanager.service.order.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class ActionOrderController {
    private OrderService orderService;

    @PutMapping("/action-order")
    public ResponseEntity<?> actionOrder(@RequestBody ActionOrderByCustomerRequest request){
        try {
            orderService.updateBookingStatus(request.getOrderId(), request.getStatus());
            return ResponseEntity.status(HttpStatus.OK).body("Thành Công");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
