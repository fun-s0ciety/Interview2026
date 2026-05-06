import java.util.Arrays;

public class LC746 {

    public static int min(int cost[], int n, int dp[]) {
        if (n < 0) return 0;
        if (n == 1 || n == 0) return cost[n];
        if (dp[n] != -1) return dp[n];
        int twoStep = cost[n] + min(cost, n-2, dp);
        int oneStep = cost[n] + min(cost, n-1, dp);
        return dp[n] = Math.min(twoStep, oneStep);
    }

    public static int minCostClimbingStairs(int[] cost) {
        int first = cost[0];
        int second = cost[1];
        int curr = 0;

        for (int i = 2; i<cost.length; i++) {
            curr = cost[i] + Math.min(first, second);
            first = second;
            second = curr;
        }

        return Math.min(first, second);
    }

    public static void main(String[] args) {
        int cost[] = {1,100,1,1,1,100,1,1,100,1};
        int dp[] = new int[cost.length];
        Arrays.fill(dp, -1);
        System.out.println(Math.min(min(cost, cost.length-1, dp), min(cost, cost.length-2, dp)));

        System.out.println(minCostClimbingStairs(cost));
    }
}