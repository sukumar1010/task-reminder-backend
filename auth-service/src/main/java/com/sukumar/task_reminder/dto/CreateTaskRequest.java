package com.sukumar.task_reminder.dto;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;




// This class validates data which comes from the endpoint called /tasks
public class CreateTaskRequest {

    @NotBlank
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
