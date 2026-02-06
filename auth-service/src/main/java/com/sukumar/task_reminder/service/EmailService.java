package com.sukumar.task_reminder.service;

import com.sukumar.task_reminder.entity.Task;
import com.sukumar.task_reminder.entity.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// This class handles to send the emails for reminder tasks and overdue tasks

//@Slf4j
@Service
public class EmailService {

    private final JavaMailSender mailSender;
    private static final Logger log =
            LoggerFactory.getLogger(EmailService.class);

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    /* --------------------
       Reminder Email
       -------------------- */
    public void sendReminderEmail(Users user, List<Task> tasks) {

        String body = buildTaskList(tasks);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("⏰ Task Reminder");
        message.setText("""
                Hello %s,

                You have tasks scheduled for today:

                %s

                Please complete them on time.

                Regards,
                Task Reminder System
                """.formatted(user.getEmail(), body));

//        mailSender.send(message);
//        log.info("📧 Sending reminder email to {}", user.getEmail());

        mailSender.send(message);

//        log.info("✅ Email sent successfully to {}", user.getEmail());

    }

    /* --------------------
       Overdue Email
       -------------------- */
    public void sendOverdueEmail(Users user, List<Task> tasks) {

        String body = buildTaskList(tasks);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("⚠️ Overdue Tasks Reminder");
        message.setText("""
                Hello %s,

                The following tasks are overdue:

                %s

                Please complete them as soon as possible.

                Regards,
                Task Reminder System
                """.formatted(user.getEmail(), body));

//        mailSender.send(message);
//        log.info("📧 Sending overdue email to {}", user.getEmail());

        mailSender.send(message);

//        log.info("✅ overdue Email sent successfully to {}", user.getEmail());
    }

    /* --------------------
       Helper method
       -------------------- */
    private String buildTaskList(List<Task> tasks) {
        return tasks.stream()
                .map(task -> "- " + task.getTitle())
                .collect(Collectors.joining("\n"));
    }

//    public void sendTestEmail(String to) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(to);
//        message.setSubject("Test Email");
//        message.setText("Email configuration is working!");
//        mailSender.send(message);
//    }

}


