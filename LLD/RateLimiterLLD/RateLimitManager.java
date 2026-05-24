package RateLimiterLLD;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimitManager {
    private Map<String, RateLimiter> limitManager;
    private RateLimiterFactory rateLimiterFactory;

    public RateLimitManager(RateLimiterFactory rateLimiterFactory) {
        this.limitManager = new ConcurrentHashMap<>();
        this.rateLimiterFactory = rateLimiterFactory;
    }

    public boolean isAllowed(String clientId) {
        RateLimiter limiter = limitManager.computeIfAbsent(clientId, k -> rateLimiterFactory.createRateLimiter());
        return limiter.tryAcquire();
    }
}
