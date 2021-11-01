package com.example.employee.crud.crudoperations.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FOUND)
public class ResourceAlreadyExistsException extends RuntimeException {
    private String message;

    public ResourceAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }

    public ResourceAlreadyExistsException() {}
}