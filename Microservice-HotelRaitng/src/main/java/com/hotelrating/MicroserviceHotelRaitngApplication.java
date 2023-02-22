package com.hotelrating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
public class MicroserviceHotelRaitngApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceHotelRaitngApplication.class, args);
    }

}
