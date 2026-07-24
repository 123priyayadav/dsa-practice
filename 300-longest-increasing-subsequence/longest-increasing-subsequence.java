class Solution {
    int[][] dp;
    public int solve(int[] nums, int i, int p) {
        if (i == nums.length)
            return 0;
        if (dp[i][p + 1] != -1)
            return dp[i][p + 1];
        int take = 0;
        if (p == -1 || nums[i] > nums[p]) {
            take = 1 + solve(nums, i + 1, i);
        }
        int notTake = solve(nums, i + 1, p);
        return dp[i][p + 1] = Math.max(take, notTake);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(dp[i], -1);
        }
        return solve(nums, 0, -1);
    }
}