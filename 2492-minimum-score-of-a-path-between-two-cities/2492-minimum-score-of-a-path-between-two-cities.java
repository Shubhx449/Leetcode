class Solution {
    private int min = Integer.MAX_VALUE;
    
    private void DFS(int idx, List<int[]>[] adj, boolean[] isVisited){
        isVisited[idx] = true;

        for (int[] neighbor : adj[idx]) {
            int next = neighbor[0], weight = neighbor[1];
            min = Math.min(min, weight);

            if (!isVisited[next]) {
                DFS(next, adj, isVisited);
            }
        }
    }

    public int minScore(int n, int[][] roads) {
        boolean[] isVisited = new boolean[n+1];
        List<int[]>[] adj = new List[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int[] road : roads) {
            adj[road[0]].add(new int[]{road[1], road[2]});
            adj[road[1]].add(new int[]{road[0], road[2]});
        }

        DFS(1,adj,isVisited);

        return min;
    }
}