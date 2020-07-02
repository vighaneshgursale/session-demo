package com.demo.exception;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String username) {
        super(username + " user already exists with same name please try another");
    }
}
