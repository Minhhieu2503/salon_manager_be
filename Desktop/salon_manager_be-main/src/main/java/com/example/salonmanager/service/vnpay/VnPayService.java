package com.example.salonmanager.service.vnpay;

import com.example.salonmanager.config.VnPayConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface VnPayService {
    String createPayment(HttpServletRequest request, int amount, String orderInfo);
    void processPaymentReturn(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
