package RateLimiterLLD;


public class Application {
    public static void main(String[] args) {
        RateLimiterFactory rateLimiterFactory = new TokenBuckerRateLimiterFactory(10, 5, 2);
        RateLimitManager limitManager = new RateLimitManager(rateLimiterFactory);
        for (int i = 0; i<=100; i++) {
            if (limitManager.isAllowed("user_123")) System.out.println("200 OK");
            else System.out.println("429 too many Requests");
        }
    }
}
