package com.hemalpatel.fundamentals.exceptions;

/**
 * Custom exception class need to directly or indirectly inherit from {@link Exception} class
 * If you inherit from {@link Exception} class new exception is considered as checked exception
 * If you inherit from {@link RuntimeException} class new exception is considered as unchecked exception
 */
public class CustomException extends Exception {

    public CustomException(String message) {
        super(message);
    }

    // Used for chained exception
    public CustomException(String message, Exception e) {
        super(message, e);
    }
}
