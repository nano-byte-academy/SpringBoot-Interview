package com.demo.events.customevent;

import jakarta.transaction.Transactional;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ApplicationEventPublisher publisher;

    public UserService(UserRepository userRepository, ApplicationEventPublisher publisher) {
        this.userRepository = userRepository;
        this.publisher = publisher;
    }

    @Transactional
    public User createUser(String name, String email) {
        // create user
        User user = new User(name, email);
        User saved = userRepository.save(user);

        // publish event with the new user's id
        publisher.publishEvent(new UserCreatedEvent(saved.getId()));

        return saved;
    }
}

