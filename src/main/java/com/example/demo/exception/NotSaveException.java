package com.example.demo.exception;

public class NotAcceptableException extends RuntimeException {

    public static final String PRE_PERSIST = "Data save failed error";

    public static final String 

    public NotAcceptableException(String message) {
        super(message);
    }
}
