package com.example.salonmanager.controller.web;

import com.example.salonmanager.dto.ComboDTO;
import com.example.salonmanager.dto.ServiceDTO;
import com.example.salonmanager.response.ServiceAndComboResponse;
import com.example.salonmanager.service.combo.ComboService;
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
public class ShowServiceAndComboController {
    private final ProductService productService;
    private final ComboService comboService;

    @GetMapping("/service-combo/{categoryId}")
    public ResponseEntity<?> getServiceAndComboByCategoryId(@PathVariable("categoryId") Integer categoryId){
        Set<ServiceDTO> serviceDTOS = productService.findAllServiceByCategoryId(categoryId);
        Set<ComboDTO> comboDTOS = comboService.findAllComboByCategoryId(categoryId);
        return ResponseEntity.status(HttpStatus.OK).body(ServiceAndComboResponse.builder()
                .serviceDTOS(serviceDTOS)
                .comboDTOS(comboDTOS)
                .build());
    }

}
