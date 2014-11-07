package com.epam.cdp.unit.exception;

/**
 * Created by ilya on 07.11.14.
 */
public class UserNotFoundException  extends Exception {

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(Throwable t) {
        super(t);
    }

    public UserNotFoundException(String message, Throwable t) {
        super(message, t);
    }
}
