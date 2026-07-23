import java.util.Arrays;
class Solution {
    int[] dp;
    public int solve(int i, int end, int[] nums) {
        if (i > end)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        int take = nums[i] + solve(i + 2, end, nums);
        int skip = solve(i + 1, end, nums);
        return dp[i] = Math.max(take, skip);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        dp = new int[n];
        Arrays.fill(dp, -1);
        int first = solve(0, n - 2, nums);
        dp = new int[n];
        Arrays.fill(dp, -1);
        int second = solve(1, n - 1, nums);
        return Math.max(first, second);
    }
}