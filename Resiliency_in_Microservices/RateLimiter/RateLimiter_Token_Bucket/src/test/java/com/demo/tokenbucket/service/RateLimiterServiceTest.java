package com.demo.tokenbucket.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RateLimiterServiceTest {

    @Autowired
    private RateLimiterService rateLimiterService;

    @Test
    void testRateLimiterAllowsOnlyTwoCallsIn10Seconds() {
        // First call: should pass
        assertDoesNotThrow(() -> rateLimiterService.getMyContent(1));

        // Second call: should pass
        assertDoesNotThrow(() -> rateLimiterService.getMyContent(2));

        // Third call: should be rate-limited
        ResponseStatusException ex = assertThrows(ResponseStatusException.class, () -> {
            rateLimiterService.getMyContent(3);
        });

        assertEquals(429, ex.getStatusCode().value()); // TOO_MANY_REQUESTS
    }

    @Test
    void testRateLimiterRefreshesAfter10Seconds() throws InterruptedException {
        // Wait for 11 seconds (give the RateLimiter sometime to add token after the above test case is run)
        Thread.sleep(11000);

        // 2 allowed calls
        rateLimiterService.getMyContent(1);
        rateLimiterService.getMyContent(2);

        // 3rd should fail
        assertThrows(ResponseStatusException.class, () -> rateLimiterService.getMyContent(3));

        // Wait for 11 seconds (to ensure refresh)
        Thread.sleep(11000);

        // Should succeed again
        assertDoesNotThrow(() -> rateLimiterService.getMyContent(4));
    }

}