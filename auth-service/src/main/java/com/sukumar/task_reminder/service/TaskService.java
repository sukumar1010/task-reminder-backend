package com.sukumar.task_reminder.service;


import com.sukumar.task_reminder.entity.Task;
import com.sukumar.task_reminder.entity.Users;
import com.sukumar.task_reminder.exception.InvalidTaskStateException;
import com.sukumar.task_reminder.exception.TaskNotFoundException;
import com.sukumar.task_reminder.exception.UnauthorizedTaskAccessException;
import com.sukumar.task_reminder.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


// This is a TaskService which handles the task related DB operations like create, Update, Delete etc..
@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(
            Users user,
            String title,
            LocalDate reminderDate,
            LocalDate dueDate
    ) {
        if(reminderDate.isBefore(LocalDate.now())){
            throw new InvalidTaskStateException("Reminder date cannot be older");
        }
        if (reminderDate.isAfter(dueDate)) {
            throw new InvalidTaskStateException(
                    "Reminder date cannot be after due date"
            );
        }

        Task task = new Task();
        task.setUser(user);
        task.setTitle(title);
        task.setReminderDate(reminderDate);
        task.setDueDate(dueDate);
        task.setCompleted(false);

        return taskRepository.save(task);
    }

    public List<Task> getTasksForUser(Users user) {
        return taskRepository.findByUser(user);
    }

    public Task getTaskById(Long taskId, Users user) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() ->
                        new TaskNotFoundException("Task not found")
                );

        if (!task.getUser().getId().equals(user.getId())) {
            throw new UnauthorizedTaskAccessException(
                    "You are not allowed to access this task"
            );
        }

        return task;
    }

    public Task markTaskAsCompleted(Long taskId, Users user) {

        Task task = getTaskById(taskId, user);

        if (task.isCompleted()) {
            throw new InvalidTaskStateException(
                    "Task is already completed"
            );
        }

        task.setCompleted(true);
        return taskRepository.save(task);
    }


    public void deleteTask(Long taskId, Users user) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() ->
                        new TaskNotFoundException("Task not found")
                );

        if (!task.getUser().getId().equals(user.getId())) {
            throw new UnauthorizedTaskAccessException(
                    "You are not allowed to delete this task"
            );
        }

        taskRepository.delete(task);
    }


    public Task updateTask(
            Long taskId,
            Users user,
            String title,
            LocalDate reminderDate,
            LocalDate dueDate
    ) {
        Task task = getTaskById(taskId, user); // ownership + not-found handled

        if (reminderDate != null && dueDate != null
                && reminderDate.isAfter(dueDate)) {
            throw new InvalidTaskStateException(
                    "Reminder date cannot be after due date"
            );
        }

        if (title != null && !title.isBlank()) {
            task.setTitle(title);
        }

        if (reminderDate != null) {
            task.setReminderDate(reminderDate);
        }

        if (dueDate != null) {
            task.setDueDate(dueDate);
        }

        return taskRepository.save(task);
    }

}
