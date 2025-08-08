package com.hightower.ace.ratelimiting;

import jakarta.servlet.ServletRequest;

public class RateLimiter {

    private RateLimitStrategy strategy;

    public RateLimiter(final RateLimitStrategy strategy) {
        this.strategy = strategy;
    }

    public void check(final String id) {

    }

}
