package com.example.salonmanager.service.chatbot;

import com.example.salonmanager.exception.LoginException;

public interface ChatBotService {
    String processMessage(String message) throws LoginException;
}

