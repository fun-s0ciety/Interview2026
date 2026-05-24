package RateLimiterLLD;

public class TokenBuckerRateLimiterFactory implements RateLimiterFactory {

    private long maxBucketSize;
    private long refillToken;
    private long refillPeriodInMilliseconds;

    public TokenBuckerRateLimiterFactory(long maxBucketSize, long refillToken, long refillPeriodInMilliseconds) {
        this.maxBucketSize = maxBucketSize;
        this.refillToken = refillToken;
        this.refillPeriodInMilliseconds = refillPeriodInMilliseconds;
    }

    @Override
    public RateLimiter createRateLimiter() {
        return new TokenBucketRateLimiter(maxBucketSize, refillToken, refillPeriodInMilliseconds);
    }
    
}
