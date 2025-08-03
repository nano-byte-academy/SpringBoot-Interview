package com.demo.tokenbucket.service;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RateLimiterService {

    private static final Logger logger =
            LoggerFactory.getLogger(RateLimiterService.class);

    @RateLimiter(name = "myRateLimiter1", fallbackMethod = "getMyContentFallback")
    public String getMyContent(Integer contentId) {
        logger.info("inside getMyContent()...");
        // do some HTTP request to third party
        return "mock content data";
    }

    public String getMyContentFallback(Integer contentId, Throwable cause) {
        logger.info("Rate limit exceeded, please retry again later!");
        throw new ResponseStatusException(HttpStatus.TOO_MANY_REQUESTS,
                "Rate limit exceeded, please retry again later!");
    }

}
