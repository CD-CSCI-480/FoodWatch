package com.codedifferently.firebaseauthenticationstarter.domain.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long userId) {
        super(userId + " not found");
    }
}