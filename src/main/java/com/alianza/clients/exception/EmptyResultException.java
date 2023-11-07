package com.alianza.clients.exception;

public class EmptyResultException extends RuntimeException {

    public EmptyResultException() {
        super();
    }

    public EmptyResultException(String errorMessage) {
        super(errorMessage);
    }

    public EmptyResultException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
