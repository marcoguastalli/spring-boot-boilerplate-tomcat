package net.marco27.java.boilerplate.exception;

import jakarta.validation.constraints.NotNull;

import java.io.Serial;

/**
 * Exception for document not found
 */
public class DocumentNotFoundException extends Exception {

    @Serial
    private static final long serialVersionUID = 9053909216641385720L;

    public DocumentNotFoundException(@NotNull String s) {
        super(s);
    }

}
