package com.rslakra.imageservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Author: Rohtash Singh Lakra
 * Created: 2019-03-05 10:49
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidUserException extends RuntimeException {
    /**
     * @param message
     */
    public InvalidUserException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public InvalidUserException(String message, Throwable cause) {
        super(message, cause);
    }
}
