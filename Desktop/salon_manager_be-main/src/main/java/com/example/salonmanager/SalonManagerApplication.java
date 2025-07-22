package com.example.salonmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class SalonManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalonManagerApplication.class, args);
        System.out.println("hello");
    }

}