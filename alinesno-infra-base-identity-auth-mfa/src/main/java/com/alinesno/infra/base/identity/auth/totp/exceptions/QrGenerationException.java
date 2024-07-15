package com.alinesno.infra.base.identity.auth.totp.exceptions;

public class QrGenerationException extends Exception {
    public QrGenerationException(String message, Throwable cause) {
        super(message, cause);
    }
}
