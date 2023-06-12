package com.phoenixsquad.driveprep_server.exceptions;

/**
 * Exception thrown when a category is not found.
 */
public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String message) {
        super(message);
    }
}
