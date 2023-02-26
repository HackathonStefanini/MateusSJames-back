package com.stefanini.handlers;

public class BadRequestHandler extends Exception{
    public BadRequestHandler() {
        super();
    }

    public BadRequestHandler(String message) {
        super(message);
    }
}
