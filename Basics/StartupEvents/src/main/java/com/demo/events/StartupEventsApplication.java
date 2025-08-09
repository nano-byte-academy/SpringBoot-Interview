package com.demo.events;

import com.demo.events.listeners.MyApplicationStartedEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartupEventsApplication {

	public static void main(String[] args) {
		// SpringApplication.run(StartupEventsApplication.class, args);

		SpringApplication app = new SpringApplication(StartupEventsApplication.class);
		// Programmatic registration of listeners (no @Component)
		app.addListeners(
				new MyApplicationStartedEventListener()
		);
		app.run(args);
	}
}
