package com.example.salonmanager.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActionOrderByCustomerRequest {
    private Integer orderId;
    private Integer status;
}

