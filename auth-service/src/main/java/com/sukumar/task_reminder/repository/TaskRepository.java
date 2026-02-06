package com.sukumar.task_reminder.repository;

import com.sukumar.task_reminder.entity.Task;
import com.sukumar.task_reminder.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

// This Task Repository helps to automate the SQL queries by writing correct method names
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // 1️⃣ Get all tasks for a specific user
    List<Task> findByUser(Users user);

    // 2️⃣ Get all pending (not completed) tasks for a user
    List<Task> findByUserAndCompletedFalse(Users user);

    // 3️⃣ Tasks that should be reminded today (first reminder)
    List<Task> findByCompletedFalseAndReminderDate(LocalDate today);

    // 4️⃣ Overdue tasks that still need reminders
    List<Task> findByCompletedFalseAndDueDateBefore(LocalDate today);

    // 5️⃣ Overdue tasks that were NOT reminded today (to avoid duplicate emails)
    List<Task> findByCompletedFalseAndDueDateBeforeAndLastRemindedOnNot(
            LocalDate today,
            LocalDate todayAgain
    );

    // Alternative safer version (recommended)
    List<Task> findByCompletedFalseAndDueDateBeforeAndLastRemindedOnIsNullOrLastRemindedOnBefore(
            LocalDate today,
            LocalDate todayAgain
    );

    List<Task> findByUserAndCompletedFalseAndReminderDate(
            Users user,
            LocalDate reminderDate
    );

    List<Task> findByUserAndCompletedFalseAndDueDateBeforeAndLastRemindedOnIsNullOrLastRemindedOnBefore(
            Users user,
            LocalDate dueDate,
            LocalDate lastRemindedOn
    );

}
