class Solution {
    int[] parent,size;

    private int find(int node){
        if(parent[node] == node) return node;
        
        return parent[node] = find(parent[node]);
    }

    private void union(int a,int b){
        a = find(a); b = find(b);
        
        if(size[a] > size[b]){
            parent[b] = a;
            size[a] += size[b];
        }else{
            parent[a] = b;
            size[b] += size[a];
        }
    }


    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        parent = new int[n];
        size = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }
        
        for (int i = 1; i<n; i++) {
            if (nums[i]-nums[i-1] <= maxDiff) union(i-1, i);
        }

        boolean[] ans = new boolean[queries.length];

        int i = 0;
        for(int[] query : queries){
            if(find(query[0]) == find(query[1])) ans[i] = true;
            i++;
        }

        return ans;
    }
}