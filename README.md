# Task Reminder Application (Spring Boot)

A backend application built using Spring Boot that provides **JWT-based authentication**, **task management**, and **automated email reminders** for pending and overdue tasks.

---

## 🚀 Features

- User registration & login with JWT authentication
- Secure REST APIs using Spring Security
- Create, update, complete, delete, and fetch tasks
- Task reminders via email
  - On reminder date
  - Daily for overdue tasks until completed
- Scheduled email notifications 
- Rate limiting for login ( email based)
- PostgreSQL database integration
- Clean layered architecture (Controller, Service, Repository)

---

## 🛠 Tech Stack

- Java 21
- Spring Boot
- Spring Security (JWT)
- Spring Data JPA
- PostgreSQL
- Hibernate
- JavaMailSender
- Maven
- JUnit & Mockito (Testing)

---

## 📦 Core Modules

- **Auth Module** – User registration & login
- **Task Module** – Task CRUD operations
- **Security Module** – JWT filters & security configuration
- **Scheduler Module** – Email reminders at fixed times
- **Email Service** – Sends reminder & overdue emails

---

## ⏰ Email Scheduler

Emails are sent automatically:
- On the task reminder date
- Daily for overdue tasks until completion

Configured using Spring’s `@Scheduled` cron jobs.

---

## 🧪 Testing

- Unit tests for services
- Integration tests for authentication & task flow
- JWT-protected endpoint testing

---




## 👤 Author

**Sukumar**  
Backend Developer | Java | Spring Boot
