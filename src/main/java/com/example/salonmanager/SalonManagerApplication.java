package com.example.salonmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Main Spring Boot application class for Salon Manager Backend
 * 
 * This class serves as the entry point for the Spring Boot application.
 * It enables various Spring Boot features including caching, async processing,
 * and scheduling capabilities.
 * 
 * @author Salon Manager Team
 * @version 1.0.0
 * @since 2024-01-01
 */
@SpringBootApplication
@EnableCaching
@EnableAsync
@EnableScheduling
public class SalonManagerApplication {

    /**
     * Main method to start the Spring Boot application
     * 
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(SalonManagerApplication.class, args);
    }
} 