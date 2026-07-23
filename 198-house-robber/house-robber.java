import java.util.Arrays;
class Solution {
    int[] dp;
    public int solve(int i, int[] nums, int n) {
        if (i >= n)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        int take = nums[i] + solve(i + 2, nums, n);
        int skip = solve(i + 1, nums, n);
        return dp[i] = Math.max(take, skip);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(0, nums, n);
    }
}