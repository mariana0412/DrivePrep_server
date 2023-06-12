package com.phoenixsquad.driveprep_server.exceptions;

/**
 * Exception thrown when a user is not found.
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
