package rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import rest.exceptions.NonExistingAbfrageException;

@RestControllerAdvice
public class MainExceptionHandler {

    @ExceptionHandler(NonExistingAbfrageException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleNonExistingAbfrage() {

    }
}
