package com.example.salonmanager.controller.employee;

import com.example.salonmanager.dto.OrderDTO;
import com.example.salonmanager.request.AllOrderEmployeeAndDateRequest;
import com.example.salonmanager.service.order.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class ShowBookedEmployeeController {
    private OrderService orderService;

    @GetMapping("/findAllBooked")
    public ResponseEntity<?> findAllOrderByEmployeeAndDate(@RequestBody AllOrderEmployeeAndDateRequest request){
        try {
            Set<OrderDTO> orderDTOS = orderService.findAllOrderByEmployeeAndDate(request);
            return ResponseEntity.status(HttpStatus.OK).body(orderDTOS);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
