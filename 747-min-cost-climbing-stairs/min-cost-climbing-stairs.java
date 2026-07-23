import java.util.Arrays;
class Solution {
    int[] dp;
    public int solve(int i, int[] cost, int n) {
        if (i >= n)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        int one = cost[i] + solve(i + 1, cost, n);
        int two = cost[i] + solve(i + 2, cost, n);
        return dp[i] = Math.min(one, two);
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return Math.min(solve(0, cost, n), solve(1, cost, n));
    }
}