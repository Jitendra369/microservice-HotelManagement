package com.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceUserServiceApplication.class, args);
    }

}
