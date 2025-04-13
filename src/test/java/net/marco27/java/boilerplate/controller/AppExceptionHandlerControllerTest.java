package net.marco27.java.boilerplate.controller;

import net.marco27.java.boilerplate.exception.ConnectionException;
import net.marco27.java.boilerplate.exception.DocumentNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AppExceptionHandlerControllerTest {

    AppExceptionHandlerController appExceptionHandlerController;

    @BeforeEach
    void init() {
        appExceptionHandlerController = new AppExceptionHandlerController();
    }

    @Test
    void testIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("no input parameter");
        });
        assertThat(exception.getMessage(), is("no input parameter"));
    }

    @Test
    void testConnectionException() {
        ConnectionException exception = assertThrows(ConnectionException.class, () -> {
            throw new ConnectionException("connection exception", null);
        });
        assertThat(exception.getMessage(), is("connection exception"));
    }

    @Test
    void testDocumentNotFoundException() {
        DocumentNotFoundException exception = assertThrows(DocumentNotFoundException.class, () -> {
            throw new DocumentNotFoundException("not found");
        });
        assertThat(exception.getMessage(), is("not found"));
    }

    @Test
    void testHandleError() {
        final ResponseEntity<String> result = appExceptionHandlerController.handleError(HttpStatus.NOT_FOUND,
                new DocumentNotFoundException("This is just a 404 Test"));
        assertThat(result.getBody(), is("This is just a 404 Test"));
        assertThat(result.getStatusCode(), is(HttpStatus.NOT_FOUND));
    }

    @Test
    void testHandleNotFoundException() {
        final ResponseEntity<String> result = appExceptionHandlerController.handleNotFoundException(
                new IllegalArgumentException("Do not instantiate Util class"));
        assertThat(result.getBody(), is("Do not instantiate Util class"));
        assertThat(result.getStatusCode(), is(HttpStatus.BAD_REQUEST));
    }

    @Test
    void testHandleContributorsApiConnectionException() {
        final ResponseEntity<String> result = appExceptionHandlerController.handleContributorsApiConnectionException(
                new ConnectionException("Connection Error", new Throwable()));
        assertThat(result.getBody(), is("Connection Error"));
        assertThat(result.getStatusCode(), is(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @Test
    void testHandleNotFound() {
        appExceptionHandlerController.handle(new DocumentNotFoundException("Not Found"));
        assertThat(appExceptionHandlerController, notNullValue());
    }
}
