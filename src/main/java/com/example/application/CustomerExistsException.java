package com.example.application;

public class CustomerExistsException extends Exception {
    public CustomerExistsException() {
    }

    public CustomerExistsException(String message) {
        super(message);
    }
}
