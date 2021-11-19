package pl.ps.demo.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.ps.demo.exception.MyCustomException;

import javax.persistence.EntityNotFoundException;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleConflict(IllegalArgumentException e) {
        return e.getMessage();
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public String handleConflict(EntityNotFoundException e) {
        return e.getMessage();
    }

    @ResponseStatus(FORBIDDEN)
    @ExceptionHandler(MyCustomException.class)
    public String handleConflict(MyCustomException e) {
        return e.getMessage();
    }

}
