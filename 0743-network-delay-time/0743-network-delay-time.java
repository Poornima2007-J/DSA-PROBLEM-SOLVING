import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge : times) {
            adj.get(edge[0]).add(new int[] {edge[1], edge[2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;
        pq.offer(new int[] {k, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int dis = curr[1];

            if (dis > dist[node]) continue;

            for (int[] it : adj.get(node)) {
                int adjNode = it[0];
                int wt = it[1];

                if (dis + wt < dist[adjNode]) {
                    dist[adjNode] = dis + wt;
                    pq.offer(new int[]{adjNode, dist[adjNode]});
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}
