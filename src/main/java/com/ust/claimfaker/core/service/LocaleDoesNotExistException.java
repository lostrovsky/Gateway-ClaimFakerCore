package com.ust.claimfaker.core.service;

public class LocaleDoesNotExistException extends RuntimeException {
    public LocaleDoesNotExistException(String message) {
        super(message);
    }
}
