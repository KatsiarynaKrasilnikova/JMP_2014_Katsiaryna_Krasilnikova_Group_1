package com.epam.cdp.ejb.exception;

/**
 * Created by ilya on 07.11.14.
 */
public class AccountNotFoundException extends Exception {

    public AccountNotFoundException() {
        super();
    }

    public AccountNotFoundException(String message) {
        super(message);
    }

    public AccountNotFoundException(Throwable t) {
        super(t);
    }

    public AccountNotFoundException(String message, Throwable t) {
        super(message, t);
    }
}
