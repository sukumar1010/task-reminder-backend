package com.sukumar.task_reminder.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


// This class handles the User table in the DB
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    public Long getId(){
        return id;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}


