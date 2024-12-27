package com.api.prueba.user.common.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Indica que esta excepción generará un código de estado HTTP 404 (Not Found)
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    // Constructor que acepta un mensaje personalizado
    public ResourceNotFoundException(String message) {
        super(message);
    }
}

