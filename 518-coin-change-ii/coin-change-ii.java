import java.util.Arrays;
class Solution {
    public int helper(int i, int n, int amount, int[] coins, int[][] dp) {
        if (amount == 0) {
            return 1;
        }
        if (i == n) {
            return 0;
        }
        if (dp[i][amount] != -1) return dp[i][amount];
        if (amount < coins[i]) {
            return dp[i][amount] = helper(i + 1, n, amount, coins, dp);
        }
        int t = helper(i, n, amount - coins[i], coins, dp);
        int nt = helper(i + 1, n, amount, coins, dp);
        return dp[i][amount] = t + nt;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(0, n, amount, coins, dp);
    }
}