package com.demo.events.listeners;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

// @Component
public class MyApplicationStartedEventListener
        implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        System.out.println("➡️  Application has started: " + event.getTimestamp());
        // …your custom logic…
    }
}
