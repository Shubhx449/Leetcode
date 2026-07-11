class Solution {
    int[] parent, size;

    private int find(int node){
        if(parent[node] == node) return node;
        return parent[node] = find(parent[node]);
    }

    private void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a == b) return;

        if(size[a] > size[b]){
            parent[b] = a;
            size[a] += size[b];
        }else{
            parent[a] = b;
            size[b] += size[a];
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        parent = new int[n];
        size = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }

        for(int[] edge : edges){
            union(edge[0], edge[1]);
        }

        int[] edgeCount = new int[n];
        for(int[] edge : edges){
            int root = find(edge[0]);
            edgeCount[root]++;
        }

        int components = 0;
        for(int i = 0; i < n; i++){
            if(find(i) == i){  
                int V = size[i];
                int E = edgeCount[i];
                if(E == V * (V - 1) / 2){
                    components++;
                }
            }
        }

        return components;
    }
}