package com.javaguide.springsecurityjwtguide.system.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    USER_NAME_ALREADY_EXIST(1001, HttpStatus.BAD_REQUEST, "username already existed"),
    Role_NOT_FOUND(1002, HttpStatus.NOT_FOUND, "not found the role"),
    USER_NAME_NOT_FOUND(1002, HttpStatus.NOT_FOUND, "not found the user"),
    VERIFY_JWT_FAILED(1003, HttpStatus.UNAUTHORIZED, "token validation fail"),
    METHOD_ARGUMENT_NOT_VALID(1003, HttpStatus.BAD_REQUEST, "argument validation fail");
    private final int code;

    private final HttpStatus status;

    private final String message;

    ErrorCode(int code, HttpStatus status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }
}
