package com.example.application;

public class WrongNumberException extends Exception {
    public WrongNumberException() {
    }

    public WrongNumberException(String message) {
        super(message);
    }
}
