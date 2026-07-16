import java.util.*;
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        boolean[] vis = new boolean[n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        pq.offer(new int[]{0, 0});

        int cost = 0;
        int count = 0;

        while (count < n) {

            int[] curr = pq.poll();

            int node = curr[0];
            int wt = curr[1];

            if (vis[node])
                continue;

            vis[node] = true;
            cost += wt;
            count++;

            for (int i = 0; i < n; i++) {

                if (!vis[i]) {

                    int dist = Math.abs(points[node][0] - points[i][0])
                             + Math.abs(points[node][1] - points[i][1]);

                    pq.offer(new int[]{i, dist});
                }
            }
        }

        return cost;
    }
}