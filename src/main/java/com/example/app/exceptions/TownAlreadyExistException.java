package com.example.app.exceptions;

public class TownAlreadyExistException extends  Exception{
    public TownAlreadyExistException(String message) {
        super(message);
    }
}
