package com.sukumar.task_reminder.dto;

import java.time.LocalDate;

// This class validates data to update the data in the database
public class UpdateTaskRequest {

    private String title;
    private LocalDate reminderDate;
    private LocalDate dueDate;

    public String getTitle() {
        return title;
    }

    public LocalDate getReminderDate() {
        return reminderDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
}

