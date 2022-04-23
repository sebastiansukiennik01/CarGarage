package com.example.application;

import java.io.CharArrayReader;

public class CarExistsException extends  Exception{
    public CarExistsException() {}

    public CarExistsException(String message) { super(message); }
}

