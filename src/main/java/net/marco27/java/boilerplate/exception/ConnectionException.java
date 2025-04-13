package net.marco27.java.boilerplate.exception;

import jakarta.validation.constraints.NotNull;

import java.io.Serial;

/**
 * Exception for Http Connection errors
 */
public class ConnectionException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -3499306730238522174L;

    public ConnectionException(@NotNull String message, @NotNull Throwable cause) {
        super(message, cause);
    }
}
