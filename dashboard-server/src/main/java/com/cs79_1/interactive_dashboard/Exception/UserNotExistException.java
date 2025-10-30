package com.cs79_1.interactive_dashboard.Exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserNotExistException extends RuntimeException {
    public UserNotExistException(long userId) {
        super("No user with id " + userId + " exists");
    }
}
