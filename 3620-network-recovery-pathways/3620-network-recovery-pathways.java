class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        
        List<int[]> validEdges = new ArrayList<>();
        Set<Integer> uniqueCosts = new TreeSet<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1], cost = e[2];
            if (!online[u] || !online[v]) continue;
            validEdges.add(e);
            uniqueCosts.add(cost);
        }
        
        if (validEdges.isEmpty()) return -1;
        
        List<Integer> costList = new ArrayList<>(uniqueCosts);
        int lo = 0, hi = costList.size() - 1, ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int S = costList.get(mid);
            
            if (feasible(validEdges, n, S, k)) {
                ans = S;
                lo = mid + 1; 
            } else {
                hi = mid - 1; 
            }
        }
        
        return ans;
    }
    
    
    private boolean feasible(List<int[]> edges, int n, int S, long k) {
        List<List<long[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for (int[] e : edges) {
            if (e[2] >= S) {
                adj.get(e[0]).add(new long[]{e[1], e[2]});
            }
        }
        
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0, 0});
        
        boolean[] visited = new boolean[n];
        
        while (!pq.isEmpty()) {
            long[] top = pq.poll();
            long d = top[0];
            int u = (int) top[1];
            
            if (visited[u]) continue;
            visited[u] = true;
            
            if (u == n - 1) break; 
            
            for (long[] edge : adj.get(u)) {
                int v = (int) edge[0];
                long cost = edge[1];
                if (!visited[v] && d + cost < dist[v]) {
                    dist[v] = d + cost;
                    pq.offer(new long[]{dist[v], v});
                }
            }
        }
        
        return dist[n - 1] <= k;
    }
}