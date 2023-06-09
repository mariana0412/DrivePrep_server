package com.phoenixsquad.driveprep_server.exceptions;

public class WrongPasswordFormat extends RuntimeException {
    private static final String ERROR_CODE = "ERR002";
    public WrongPasswordFormat(String message) {
        super(message);
    }

    public String getErrorCode() {
        return ERROR_CODE;
    }
}
