package com.hightower.ace.ratelimiting;

public interface RateLimitStrategy {

    boolean hasCapacity(final String identifier);

    void cleanup();

}
