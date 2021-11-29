package pl.ps.demo.controller;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.ps.demo.exception.AuthException;
import pl.ps.demo.exception.MyCustomException;
import pl.ps.demo.exception.ValidationException;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

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

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MyCustomException.class)
    public String handleConflict(MyCustomException e) {
        return e.getMessage();
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public List<String> handleConflict(ValidationException e) {
        return e.getExceptionList();
    }

    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(BAD_REQUEST)
    public List<String> handleConstraintViolationException(ConstraintViolationException e) {
        return e.getConstraintViolations().stream().map(ConstraintViolation::getMessageTemplate).collect(Collectors.toList());
    }
}
