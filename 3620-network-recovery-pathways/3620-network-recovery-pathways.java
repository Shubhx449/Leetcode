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
        
        List<List<int[]>> adjFull = new ArrayList<>();
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) adjFull.add(new ArrayList<>());
        
        for (int[] e : validEdges) {
            adjFull.get(e[0]).add(new int[]{e[1], e[2]});
            indegree[e[1]]++;
        }
        
        int[] topoOrder = new int[n];
        int idx = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int u = queue.poll();
            topoOrder[idx++] = u;
            for (int[] edge : adjFull.get(u)) {
                int v = edge[0];
                if (--indegree[v] == 0) queue.offer(v);
            }
        }
        
        List<Integer> costList = new ArrayList<>(uniqueCosts);
        int lo = 0, hi = costList.size() - 1, ans = -1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int S = costList.get(mid);
            
            if (feasible(validEdges, n, S, k, topoOrder)) {
                ans = S;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return ans;
    }
    
    private boolean feasible(List<int[]> edges, int n, int S, long k, int[] topoOrder) {
        List<List<long[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for (int[] e : edges) {
            if (e[2] >= S) {
                adj.get(e[0]).add(new long[]{e[1], e[2]});
            }
        }
        
        long[] dp = new long[n];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;
        
        for (int u : topoOrder) {
            if (dp[u] == Long.MAX_VALUE) continue;
            for (long[] edge : adj.get(u)) {
                int v = (int) edge[0];
                long cost = edge[1];
                if (dp[u] + cost < dp[v]) {
                    dp[v] = dp[u] + cost;
                }
            }
        }
        
        return dp[n - 1] <= k;
    }
}