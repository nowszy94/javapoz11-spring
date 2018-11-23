package com.sda.javapoz11.hellospring.hellospring.entity;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
