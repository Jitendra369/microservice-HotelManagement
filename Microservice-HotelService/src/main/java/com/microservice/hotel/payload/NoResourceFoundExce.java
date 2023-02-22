package com.microservice.hotel.payload;

public class NoResourceFoundExce extends RuntimeException{

    public NoResourceFoundExce() {
        super();
    }

    public NoResourceFoundExce(String message) {
        super(message);
    }
}
