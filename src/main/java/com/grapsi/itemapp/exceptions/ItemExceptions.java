package com.grapsi.itemapp.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ItemExceptions extends RuntimeException{
private String message;
private HttpStatus httpStatus;

    public ItemExceptions(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
