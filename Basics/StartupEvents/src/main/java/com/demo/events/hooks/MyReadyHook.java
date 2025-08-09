package com.demo.events.hooks;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyReadyHook {

    @EventListener(condition = "#event.args.length > 0")
    public void onReady(ApplicationReadyEvent event) {
        System.out.println("✅  Application is ready to serve requests!");
        // …e.g. warm caches, notify external services…
    }
}
