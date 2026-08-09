package com.traintracker.backend.exception;

public class StationAlreadyExistsException extends RuntimeException {
    public StationAlreadyExistsException(String message) {
        super(message);
    }
}

