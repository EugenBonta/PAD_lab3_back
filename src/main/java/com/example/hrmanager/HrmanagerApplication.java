package com.example.hrmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HrmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrmanagerApplication.class, args);
    }

}
