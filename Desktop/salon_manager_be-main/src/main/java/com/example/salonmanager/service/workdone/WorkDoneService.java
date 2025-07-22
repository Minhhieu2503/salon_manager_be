package com.example.salonmanager.service.workdone;

import com.example.salonmanager.exception.LoginException;
import com.example.salonmanager.request.AddWorkDoneInOrderRequest;

public interface WorkDoneService {
    String addWorkDoneInOrder(AddWorkDoneInOrderRequest request) throws LoginException;
}

