package RateLimiterLLD;

public interface RateLimiter {
    public boolean tryAcquire();
}
