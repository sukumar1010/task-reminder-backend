package com.sukumar.task_reminder.controller;

import com.sukumar.task_reminder.dto.CreateTaskRequest;
import com.sukumar.task_reminder.dto.TaskResponse;
import com.sukumar.task_reminder.dto.UpdateTaskRequest;
import com.sukumar.task_reminder.entity.Task;
import com.sukumar.task_reminder.entity.Users;
import com.sukumar.task_reminder.service.TaskService;
import com.sukumar.task_reminder.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// This handles the Task endpoints
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    private TaskResponse mapToResponse(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getReminderDate(),
                task.getDueDate(),
                task.isCompleted(),
                task.getCreatedAt(),
                task.getUpdatedAt()
        );
    }


//   Create Task
    @PostMapping
    public ResponseEntity<TaskResponse> createTask(
            @AuthenticationPrincipal String email,
            @RequestBody CreateTaskRequest request
    ) {
        Users user = userService.findByEmail(email);
        Task task = taskService.createTask(
                user,
                request.getTitle(),
                request.getReminderDate(),
                request.getDueDate()
        );

        return ResponseEntity.ok(mapToResponse(task));
    }

//    Get All Tasks  for the User
    @GetMapping
    public ResponseEntity<List<TaskResponse>> getAllTasks(
            Authentication authentication

    ) {
        String email = authentication.getName();

        Users user = userService.findByEmail(email);

        List<TaskResponse> responses = taskService.getTasksForUser(user)
                .stream()
                .map(this::mapToResponse)
                .toList();

        return ResponseEntity.ok(responses);
    }



//  Mark Task as Completed
    @PutMapping("/{taskId}/complete")
    public ResponseEntity<TaskResponse> completeTask(
            @PathVariable Long taskId,
            @AuthenticationPrincipal String email
    ) {
        Users user = userService.findByEmail(email);
        Task task = taskService.markTaskAsCompleted(taskId, user);
        return ResponseEntity.ok(mapToResponse(task));
    }


//  Delete Task
    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(
            @PathVariable Long taskId,
            @AuthenticationPrincipal String email
    ) {
        Users user = userService.findByEmail(email);
        taskService.deleteTask(taskId, user);
        return ResponseEntity.noContent().build(); // 204
    }


//   Update Task filed
    @PutMapping("/{taskId}")
    public ResponseEntity<TaskResponse> updateTask(
            @PathVariable Long taskId,
            @AuthenticationPrincipal String email,
            @RequestBody UpdateTaskRequest request
    ) {
        Users user = userService.findByEmail(email);

        Task updatedTask = taskService.updateTask(
                taskId,
                user,
                request.getTitle(),
                request.getReminderDate(),
                request.getDueDate()
        );

        return ResponseEntity.ok(mapToResponse(updatedTask));
    }

}
