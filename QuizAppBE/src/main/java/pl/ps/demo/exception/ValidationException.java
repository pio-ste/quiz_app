package pl.ps.demo.exception;

import java.util.List;

public class ValidationException extends RuntimeException{

    private final List<String> exceptionList;

    public ValidationException(List<String> exceptionList) {
        this.exceptionList = exceptionList;
    }

    public List<String> getExceptionList() {
        return exceptionList;
    }
}
