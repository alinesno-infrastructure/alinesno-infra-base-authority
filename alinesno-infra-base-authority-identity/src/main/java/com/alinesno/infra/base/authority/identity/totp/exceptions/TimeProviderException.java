package com.alinesno.infra.base.authority.identity.totp.exceptions;

public class TimeProviderException extends RuntimeException {
    public TimeProviderException(String message) {
        super(message);
    }
    public TimeProviderException(String message, Throwable cause) {
        super(message, cause);
    }
}
