package com.sukumar.task_reminder.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

// This class handles the Task table in the DB
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Each task belongs to one user
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private Users user;

    @Column(nullable = false)
    private String title;

    @Column(name = "reminder_date", nullable = false)
    private LocalDate reminderDate;

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @Column(nullable = false)
    private boolean completed = false;

    @Column(name = "last_reminded_on")
    private LocalDate lastRemindedOn;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReminderDate() {
        return reminderDate;
    }

    public void setReminderDate(LocalDate reminderDate) {
        this.reminderDate = reminderDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDate getLastRemindedOn() {
        return lastRemindedOn;
    }

    public void setLastRemindedOn(LocalDate lastRemindedOn) {
        this.lastRemindedOn = lastRemindedOn;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
