package com.demo.events.customevent;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserCreatedListener {

    @EventListener
    public void handleUserCreated(UserCreatedEvent event) {
        Long userId = event.getUserId();
        // perform follow-up action (e.g. send welcome email)
        System.out.println("User created with id: " + userId);
    }
}
