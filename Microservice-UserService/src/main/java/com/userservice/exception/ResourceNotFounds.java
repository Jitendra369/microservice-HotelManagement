package com.userservice.exception;

public class ResourceNotFounds extends RuntimeException{
    private String message;

    public ResourceNotFounds(){
        super("resource not found");
    }

    public ResourceNotFounds(String message){
        super(message);
        this.message = message;
    }
}
