package com.sukumar.task_reminder.exception;

public class UnauthorizedTaskAccessException extends RuntimeException {
    public UnauthorizedTaskAccessException(String message) {
        super(message);
    }
}
