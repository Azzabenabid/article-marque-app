package com.example.servicemarque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ServiceMarqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceMarqueApplication.class, args);
    }

}
