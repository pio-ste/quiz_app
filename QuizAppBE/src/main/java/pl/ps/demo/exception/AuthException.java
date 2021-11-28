package pl.ps.demo.exception;

import org.springframework.security.core.AuthenticationException;

public class AuthException extends AuthenticationException {
    public AuthException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public AuthException(String msg) {
        super(msg);
    }
}
