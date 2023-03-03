package com.microservice.hotel.controller;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @GetMapping("/")
    public ResponseEntity<?> getAllStaff(){
        List<String> strings = Arrays.asList("ram", "shyam", "reena", "meeta");
        return new ResponseEntity<>(strings, HttpStatus.OK);
    }
}
