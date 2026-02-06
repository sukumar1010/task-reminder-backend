package com.sukumar.task_reminder.service;

import com.sukumar.task_reminder.entity.Users;
import com.sukumar.task_reminder.exception.EmailAlreadyExistsException;
import com.sukumar.task_reminder.exception.InvalidCredentialsException;
import com.sukumar.task_reminder.repository.UserRepository;
import com.sukumar.task_reminder.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


// This service handles the user creation,  user login and find user by email on the DB
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public UserService(UserRepository userRepository,PasswordEncoder passwordEncoder,JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }


    public Users register(String email, String password) {

        if (userRepository.findByEmail(email).isPresent()) {
            throw new EmailAlreadyExistsException("Email already registered");
        }

        Users user = new Users();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        return userRepository.save(user);
    }

    public String login(String email, String rawPassword) {

        Users user = userRepository.findByEmail(email)
                .orElseThrow(() -> new InvalidCredentialsException("check your email or Invalid credentials"));

        if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
            throw new InvalidCredentialsException("Invalid credentials");
        }

        return jwtUtil.generateToken(user.getEmail());
    }


//    public List<Users> getAllUsers() {
//        return userRepository.findAll();
//    }

    public Users findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found")
                );
    }

}
