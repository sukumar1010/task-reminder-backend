package com.sukumar.task_reminder.scheduler;


import com.sukumar.task_reminder.entity.Task;
import com.sukumar.task_reminder.entity.Users;
import com.sukumar.task_reminder.repository.TaskRepository;
import com.sukumar.task_reminder.repository.UserRepository;
import com.sukumar.task_reminder.service.EmailService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

// This class helps to send email's to remind about user tasks every day at 7 AP amd & PM
@Component
public class TaskEmailScheduler {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    private final EmailService emailService;

    public TaskEmailScheduler(
            UserRepository userRepository,
            TaskRepository taskRepository,
            EmailService emailService
    ) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
        this.emailService = emailService;
    }

    // Runs every day at 7 AM and 7 PM
    @Scheduled(cron = "0 0 7,19 * * *")
//    @Scheduled(cron = "0 55 16 * * *", zone = "Asia/Kolkata")
//    @Scheduled(cron = "0 12 17 * * *")
    public void sendTaskReminders() {

        LocalDate today = LocalDate.now();
        List<Users> users = userRepository.findAll();

        for (Users user : users) {

            //  Reminder tasks for THIS USER ONLY
            List<Task> reminderTasks =
                    taskRepository.findByUserAndCompletedFalseAndReminderDate(
                            user, today
                    );

            //  Overdue tasks for THIS USER ONLY
            List<Task> overdueTasks =
                    taskRepository
                            .findByUserAndCompletedFalseAndDueDateBeforeAndLastRemindedOnIsNullOrLastRemindedOnBefore(
                                    user, today, today
                            );

            if (!reminderTasks.isEmpty()) {
                emailService.sendReminderEmail(user, reminderTasks);
            }

            if (!overdueTasks.isEmpty()) {
                emailService.sendOverdueEmail(user, overdueTasks);
            }
        }
    }

}

