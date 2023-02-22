package com.microservice.hotel.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse {

    private String message;
    private HttpStatus httpStatus;
    private boolean status;
}
