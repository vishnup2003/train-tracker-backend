package com.traintracker.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StationAlreadyExistsException.class)
    public ResponseEntity<Map<String, Object>> handleStationAlreadyExists(
            StationAlreadyExistsException ex) {

        Map<String, Object> response = new HashMap<>();
        response.put("status", 409);
        response.put("message", ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
}

