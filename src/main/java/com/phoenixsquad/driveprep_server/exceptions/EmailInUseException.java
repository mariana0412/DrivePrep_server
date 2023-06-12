package com.phoenixsquad.driveprep_server.exceptions;

/**
 * Exception thrown when an email is already in use.
 */
public class EmailInUseException extends RuntimeException {
    public EmailInUseException(String message) {
        super(message);
    }
}
