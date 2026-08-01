class Solution {
    int[][][] dp;
    int m, n;
    int solve(int[][] grid, int i, int j1, int j2) {
        if (j1 < 0 || j1 >= n || j2 < 0 || j2 >= n)
            return -(int)1e8;
        if (i == m - 1) {
            if (j1 == j2)
                return grid[i][j1];
            return grid[i][j1] + grid[i][j2];
        }
        if (dp[i][j1][j2] != -1)
            return dp[i][j1][j2];
        int maxi = -(int)1e8;
        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {
                int val = solve(grid, i + 1, j1 + d1, j2 + d2);
                maxi = Math.max(maxi, val);
            }
        }
        int cherries;
        if (j1 == j2)
            cherries = grid[i][j1];
        else
        cherries = grid[i][j1] + grid[i][j2];
        return dp[i][j1][j2] = cherries + maxi;
    }
    public int cherryPickup(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new int[m][n][n];
        for (int[][] a : dp)
            for (int[] b : a)
                Arrays.fill(b, -1);
        return solve(grid, 0, 0, n - 1);
    }
}