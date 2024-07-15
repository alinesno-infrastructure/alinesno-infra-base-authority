package com.alinesno.infra.base.identity.auth.totp.exceptions;

public class CodeGenerationException extends Exception {
    public CodeGenerationException(String message, Throwable cause) {
        super(message, cause);
    }
}
