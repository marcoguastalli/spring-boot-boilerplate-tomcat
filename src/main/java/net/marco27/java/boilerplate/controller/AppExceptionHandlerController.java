package net.marco27.java.boilerplate.controller;

import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import net.marco27.java.boilerplate.exception.ConnectionException;
import net.marco27.java.boilerplate.exception.DocumentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.*;

/**
 * Handler fot Exceptions
 */
@RestControllerAdvice
@Slf4j
public class AppExceptionHandlerController extends ResponseEntityExceptionHandler {

    ResponseEntity<String> handleError(@NotNull HttpStatus status, @NotNull Exception e) {
        log.error("Exception: ", e);
        return ResponseEntity.status(status).body(e.getMessage());
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<String> handleNotFoundException(@NotNull IllegalArgumentException e) {
        return handleError(BAD_REQUEST, e);
    }

    @ExceptionHandler({ConnectionException.class})
    public ResponseEntity<String> handleContributorsApiConnectionException(@NotNull ConnectionException e) {
        return handleError(INTERNAL_SERVER_ERROR, e);
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler({DocumentNotFoundException.class})
    public void handle(@NotNull DocumentNotFoundException e) {
        log.error("Document not found: ", e);
    }
}
