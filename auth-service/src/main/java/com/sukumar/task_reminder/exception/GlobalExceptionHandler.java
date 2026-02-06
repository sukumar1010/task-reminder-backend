package com.sukumar.task_reminder.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

// This class handles the Custom Exceptions
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<?> handleEmailExists(EmailAlreadyExistsException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)   // 409
                .body(ex.getMessage());
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<?> handleInvalidCredentials(InvalidCredentialsException ex) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED) // 401
                .body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneric(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Something went wrong");
    }


    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<?> handleTaskNotFound(TaskNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND) // 404
                .body(ex.getMessage());
    }

    @ExceptionHandler(UnauthorizedTaskAccessException.class)
    public ResponseEntity<?> handleUnauthorizedTaskAccess(UnauthorizedTaskAccessException ex) {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN) // 403
                .body(ex.getMessage());
    }

    @ExceptionHandler(InvalidTaskStateException.class)
    public ResponseEntity<?> handleInvalidTaskState(InvalidTaskStateException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST) // 400
                .body(ex.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFound(UserNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }



    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(
            MethodArgumentNotValidException ex
    ) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        errors.put(error.getField(), error.getDefaultMessage())
                );

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(
            IllegalArgumentException ex
    ) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }


}
