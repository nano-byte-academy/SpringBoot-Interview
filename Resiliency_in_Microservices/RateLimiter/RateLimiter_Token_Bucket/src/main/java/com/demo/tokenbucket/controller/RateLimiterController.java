package com.demo.tokenbucket.controller;

import com.demo.tokenbucket.service.RateLimiterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RateLimiterController {

    private final RateLimiterService rateLimiterService;

    public RateLimiterController (RateLimiterService rateLimiterService) {
        this.rateLimiterService  = rateLimiterService;
    }

    @GetMapping("/getContent")
    public String getAllUsers() {
        return rateLimiterService.getMyContent(1);
    }
}
