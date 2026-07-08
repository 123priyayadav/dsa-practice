class Solution {
    public void dfs(int[][] grid, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 1)
            return;
        grid[i][j] = 1;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 0)
                dfs(grid, i, 0);
            if (grid[i][m - 1] == 0)
                dfs(grid, i, m - 1);
        }
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 0)
                dfs(grid, 0, j);

            if (grid[n - 1][j] == 0)
                dfs(grid, n - 1, j);
        }
        int count = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (grid[i][j] == 0) {
                    count++;
                    dfs(grid, i, j);
                }

            }
        }
        return count;
    }
}