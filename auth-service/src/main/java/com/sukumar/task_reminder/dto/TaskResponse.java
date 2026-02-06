package com.sukumar.task_reminder.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

// This class is used to return necessary data by mapping the actual data
public class TaskResponse {

    private Long id;
    private String title;
    private LocalDate reminderDate;
    private LocalDate dueDate;
    private boolean completed;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TaskResponse(
            Long id,
            String title,
            LocalDate reminderDate,
            LocalDate dueDate,
            boolean completed,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.id = id;
        this.title = title;
        this.reminderDate = reminderDate;
        this.dueDate = dueDate;
        this.completed = completed;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // getters only (no setters)
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getReminderDate() {
        return reminderDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }


    public boolean isCompleted() {
        return completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}

