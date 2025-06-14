package com.example.servicearticle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceArticleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceArticleApplication.class, args);
    }

}
