package com.example.salonmanager.service.zalopay;

import com.example.salonmanager.request.PaymentRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public interface ZaloPayService {
    Map<String, Object> createPayment(PaymentRequest request) throws Exception;

    void processPaymentReturn(HttpServletRequest request, HttpServletResponse response) throws IOException;
}

