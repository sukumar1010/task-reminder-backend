package com.sukumar.task_reminder.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


// This class validates data which comes from the endpoint called /register
public class RegisterRequest {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


