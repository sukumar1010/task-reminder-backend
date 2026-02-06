package com.sukumar.task_reminder.service;


import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// This class handles the rate limit for the login endpoint
@Service
public class RateLimitService {

    private static final int IP_LIMIT = 10;
    private static final int EMAIL_LIMIT = 5;
    private static final long WINDOW_MS = 60 * 60 * 1000;

    private final Map<String, Attempt> ipAttempts = new ConcurrentHashMap<>();
    private final Map<String, Attempt> emailAttempts = new ConcurrentHashMap<>();

    public boolean isIpAllowed(String ip) {
        return check(ipAttempts, ip, IP_LIMIT);
    }

    public boolean isEmailAllowed(String email) {
        return check(emailAttempts, email.toLowerCase(), EMAIL_LIMIT);
    }

    private boolean check(Map<String, Attempt> store, String key, int limit) {
        long now = System.currentTimeMillis();

        store.compute(key, (k, attempt) -> {
            if (attempt == null || now - attempt.startTime > WINDOW_MS) {
                return new Attempt(1, now);
            }
            attempt.count++;
            return attempt;
        });

        return store.get(key).count <= limit;
    }

    private static class Attempt {
        int count;
        long startTime;

        Attempt(int count, long startTime) {
            this.count = count;
            this.startTime = startTime;
        }
    }
}

