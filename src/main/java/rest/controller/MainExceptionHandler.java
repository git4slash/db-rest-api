package rest.controller;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import rest.exceptions.EntityNotFoundException;
import rest.exceptions.FieldOrSetterNotFoundException;

@RestControllerAdvice
public class MainExceptionHandler {

    @ResponseBody
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    VndErrors entityNotFoundExceptionHandler(EntityNotFoundException ex) {
        return new VndErrors("error", ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(FieldOrSetterNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    VndErrors fieldOrSetterNotFoundExceptionHandler(FieldOrSetterNotFoundException ex) {
        return new VndErrors("error", ex.getMessage());
    }

}
