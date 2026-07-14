import java.util.*;
class Solution {
    int find(int i, int[] p) {
        if (p[i] == i)
            return i;
        return p[i] = find(p[i], p);
    }
    void UNION(int x, int y, int[] p, int[] r) {
        int px = find(x, p);
        int py = find(y, p);
        if (px == py)
            return;
        if (r[px] > r[py]) {
            p[py] = px;
        } 
        else if (r[px] < r[py]) {
            p[px] = py;
        } 
        else {
            p[py] = px;
            r[px]++;
        }
    }
    public boolean validPath(int n, int[][] e, int s, int d) {
        int[] p = new int[n];
        int[] r = new int[n];
        Arrays.fill(r, 0);
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        for (int[] a : e) {
            int u = a[0];
            int v = a[1];
            UNION(u, v, p, r);
        }
        return find(s, p) == find(d, p);
    }
}