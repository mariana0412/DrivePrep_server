package com.phoenixsquad.driveprep_server.exceptions;

public class InvalidOldPasswordException extends RuntimeException {
    private static final String ERROR_CODE = "ERR001";
    public InvalidOldPasswordException(String message) {
        super(message);
    }

    public String getErrorCode() {
        return ERROR_CODE;
    }
}
