package com.userservice.exception;

import com.userservice.payload.ApiResponse;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

//    userid not found exception handler
    @ExceptionHandler(ResourceNotFounds.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFounds ex ){
        String message = ex.getMessage();
        ApiResponse apiResponseBuilder = ApiResponse.builder().message(message).success(true).httpStatus(HttpStatus.NOT_FOUND).build();
        return new  ResponseEntity<ApiResponse>(apiResponseBuilder, HttpStatus.NOT_FOUND);
    }

}
