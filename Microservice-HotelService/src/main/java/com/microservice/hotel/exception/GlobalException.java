package com.microservice.hotel.exception;

import com.microservice.hotel.payload.APIResponse;
import com.microservice.hotel.payload.NoResourceFoundExce;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(NoResourceFoundExce.class)
    public ResponseEntity<APIResponse> handleIdNotFound(NoResourceFoundExce exception){

        String errorMessage = exception.getMessage();
        APIResponse apiResponse = new APIResponse(errorMessage, HttpStatus.NOT_FOUND, false);
        return  new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

//    another way
    /*@ExceptionHandler(NoResourceFoundExce.class)
    public ResponseEntity<Map<String, Object>> hsandleIdNotFound(NoResourceFoundExce exception){
        Map<String, Object> map = new HashMap();
        String errorMessage = exception.getMessage();
        map.put("message", errorMessage);
        map.put("status",HttpStatus.NOT_FOUND);
        map.put("success", false);

        return ResponseEntity.ok(map);
    }*/
}
