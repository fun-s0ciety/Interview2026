package RateLimiterLLD;

public class TokenBucketRateLimiter implements RateLimiter {

    private long maxBucketSize;
    private long refillRate;
    private long lastRefillTimeStamp;
    private long currentBucketSize;

    public TokenBucketRateLimiter(long maxBucketSize, long refillToken, long refillPeriodInMilliseconds) {
        this.maxBucketSize = maxBucketSize;
        this.refillRate = refillToken / refillPeriodInMilliseconds;
        this.currentBucketSize = maxBucketSize;
        this.lastRefillTimeStamp = System.currentTimeMillis();
    }

    @Override
    public synchronized boolean tryAcquire() {
        refill();
        if (currentBucketSize >= 1) {
            currentBucketSize -= 1;
            return true;
        }
        return false;
    }

    private void refill() {
        long now = System.currentTimeMillis();
        long elapsedTime = now - lastRefillTimeStamp;
        if (elapsedTime > 0) {
            long refillTokens = refillRate * elapsedTime;
            currentBucketSize = Math.min(maxBucketSize, refillTokens+currentBucketSize);
            lastRefillTimeStamp = now;
        } 
    }
    
}
