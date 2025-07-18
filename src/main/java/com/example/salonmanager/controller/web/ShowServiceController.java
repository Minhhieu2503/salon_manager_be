package com.example.salonmanager.controller.web;

import com.example.salonmanager.dto.ComboDTO;
import com.example.salonmanager.dto.ServiceDTO;
import com.example.salonmanager.response.ShowAllServiceByComboIdResponse;
import com.example.salonmanager.service.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/web")
@AllArgsConstructor
public class ShowServiceController {
    private ProductService productService;

    @GetMapping("/findAllService")
    public ResponseEntity<?> findAllCombo(){
        try {
            Set<ServiceDTO> serviceDTOS = productService.findAllService();
            return ResponseEntity.status(HttpStatus.OK).body(serviceDTOS);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/findAllService/{comboId}")
    public ResponseEntity<?> findAllServiceByComboId(@PathVariable("comboId") Integer comboId){
        try {
            Set<ShowAllServiceByComboIdResponse> serviceDTOS = productService.findAllServiceByComboId(comboId);
            return ResponseEntity.status(HttpStatus.OK).body(serviceDTOS);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
