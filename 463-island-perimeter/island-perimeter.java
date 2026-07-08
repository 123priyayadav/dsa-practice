class Solution {
    public int dfs(int[][] grid, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0)
            return 1;
        if (grid[i][j] == -1)
            return 0;
        grid[i][j] = -1;
        int perimeter = 0;

        perimeter += dfs(grid, i - 1, j);
        perimeter += dfs(grid, i + 1, j);
        perimeter += dfs(grid, i, j - 1);
        perimeter += dfs(grid, i, j + 1);
        return perimeter;
    }

    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }

            }
        }
        return 0;
    }
}