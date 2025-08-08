package com.hightower.ace.ratelimiting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class TokenBucketStrategy implements RateLimitStrategy {

    private static Logger log = LoggerFactory.getLogger(TokenBucketStrategy.class);

    private final Map<String, Integer> remaining;
    private final int capacity;
    private final ScheduledExecutorService executor;

    // TODO JH refiller logic should be part of this
    public TokenBucketStrategy(final int capacity, final int periodMs) {
        this.capacity = capacity;
        this.remaining = new HashMap<>();
        this.executor = Executors.newSingleThreadScheduledExecutor();
        this.executor.scheduleAtFixedRate(this::incAll, 0, periodMs, TimeUnit.MILLISECONDS);
    }

    @Override
    public synchronized boolean hasCapacity(final String identifier) {
        if (this.remaining.containsKey(identifier)) {
            int tokens = this.remaining.get(identifier);
            if (tokens > 0) {
                log.info("{} for '{}'", tokens - 1, identifier);
                this.remaining.put(identifier, tokens - 1);
                return true;
            }
        } else {
            log.info("{} for '{}'", capacity - 1, identifier);
            this.remaining.put(identifier, capacity - 1);
            return true;
        }
        log.info("No capacity for '{}'", identifier);
        return false;
    }

    @Override
    public void cleanup() {
        this.executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (final InterruptedException e) {
            executor.shutdownNow();
        }
    }

    private synchronized void incAll() {
        if (!this.remaining.isEmpty()) {
            log.info("Adding token");
        }
        this.remaining.replaceAll((k, v)-> v < this.capacity ? v+1 : v);
    }

}
