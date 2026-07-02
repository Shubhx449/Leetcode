class Solution {
    private static final int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size(), n = grid.getFirst().size();
        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);

        dp[0][0] = grid.getFirst().getFirst();

        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{0,0});

        while(!dq.isEmpty()){
            int[] temp = dq.pollFirst();
            int x = temp[0], y = temp[1];
            
            for(int[] dir : dirs){
                int r = dir[0]+x, c = dir[1]+y;
                if(r < 0 || c < 0 || r >= m || c >= n) continue;
                
                int val = grid.get(r).get(c);
                if (dp[x][y] + val >= dp[r][c]) continue;
                
                dp[r][c] = Math.min(dp[r][c],dp[x][y]+val);
                
                
                if(val == 1) dq.addLast(new int[]{r,c});
                else dq.addFirst(new int[]{r,c});
            }
        }

        return dp[m-1][n-1] < health;
    }
}