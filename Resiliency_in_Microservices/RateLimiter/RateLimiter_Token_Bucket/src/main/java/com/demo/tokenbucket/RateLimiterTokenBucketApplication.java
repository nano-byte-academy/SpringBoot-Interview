package com.demo.tokenbucket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RateLimiterTokenBucketApplication {

	public static void main(String[] args) {
		SpringApplication.run(RateLimiterTokenBucketApplication.class, args);
	}

}
