// exception/GlobalExceptionHandler.java
package com.example.m_paridarshan.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBadRequest(Exception ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
