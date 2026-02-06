package com.sukumar.task_reminder.controller;

import com.sukumar.task_reminder.dto.LoginRequest;
import com.sukumar.task_reminder.dto.RegisterRequest;
import com.sukumar.task_reminder.service.RateLimitService;
import com.sukumar.task_reminder.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


// This File handles Authentication Endpoints
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final RateLimitService rateLimitService;

    public AuthController(UserService userService, RateLimitService rateLimitService) {
        this.userService = userService;
        this.rateLimitService = rateLimitService;
    }

//    This Endpoint works for to register new user
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request){
        userService.register(request.getEmail(),request.getPassword());
        return ResponseEntity.ok("User registered successfully");
    }


//  This endpoint is for to login and it handles rate limiting
    @PostMapping("/login")
    public ResponseEntity<?> login(
            @Valid @RequestBody LoginRequest request,
            HttpServletRequest httpRequest
    ) {
        String ip = httpRequest.getRemoteAddr();
        String email = request.getEmail();

        if (!rateLimitService.isIpAllowed(ip)) {
            return ResponseEntity.status(429)
                    .body("Too many login attempts from this IP. Try later.");
        }

        if (!rateLimitService.isEmailAllowed(email)) {
            return ResponseEntity.status(429)
                    .body("Too many login attempts for this email. Try later.");
        }

        String token = userService.login(email, request.getPassword());
        return ResponseEntity.ok(token);
    }

}

