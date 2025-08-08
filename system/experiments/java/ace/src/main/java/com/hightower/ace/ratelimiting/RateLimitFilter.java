package com.hightower.ace.ratelimiting;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class RateLimitFilter extends OncePerRequestFilter {

    private RateLimitStrategy strategy;

    public RateLimitFilter() {
        // TODO JH handle config through properties
        this.strategy = new TokenBucketStrategy(5, 5000);
    }

    @Override
    protected void doFilterInternal(final HttpServletRequest request,
                                    final HttpServletResponse response,
                                    final FilterChain filterChain) throws ServletException, IOException {
        // TODO JH retrieve some sort of identifier from the request
        final String identifier = "";
        // TODO JH allow the strategy to return information about when to retry
        if (this.strategy.hasCapacity(identifier)) {
            filterChain.doFilter(request,response);
        } else {
            // TODO JH add rate limiting headers based on retry information
            response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
        }
    }
}
