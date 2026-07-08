class Solution {
    public boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        int n = grid2.length;
        int m = grid2[0].length;
if (i < 0 || j < 0 || i >= n || j >= m || grid2[i][j] == 0)
            return true;
           grid2[i][j] = 0;
           boolean ans = true;
          if (grid1[i][j] == 0)
            ans = false;
         boolean up = dfs(grid1, grid2, i - 1, j);
        boolean down = dfs(grid1, grid2, i + 1, j);
        boolean left = dfs(grid1, grid2, i, j - 1);
        boolean right = dfs(grid1, grid2, i, j + 1);
        return ans && up && down && left && right;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid2.length;
        int m = grid2[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid2[i][j] == 1) {
                    if (dfs(grid1, grid2, i, j))
                        count++;
                }
            }
        }
        return count;
    }
}