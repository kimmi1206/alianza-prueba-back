package com.alianza.clients.exception;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException() {
        super();
    }

    public ClientNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public ClientNotFoundException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
