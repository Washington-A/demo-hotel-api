package com.example.demohotelapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HotelUnavailableException extends RuntimeException{
    public HotelUnavailableException(String message) {
        super(message);
    }
}
