class Solution {
    private boolean[][] isVisited;
    private int[][] dirs;
    
    public Solution() {
        dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    }
    
    private long getSum(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || isVisited[i][j]){
            return 0;
        }
        
        isVisited[i][j] = true;
        
        long sum = grid[i][j];
        for(int[] dir : dirs){
            sum += getSum(grid, i+dir[0], j+dir[1]);
        }
        
        return sum;
    }
    public int countIslands(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        isVisited = new boolean[m][n];

        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if (grid[i][j] != 0 && !isVisited[i][j]) {
                    long sum = getSum(grid, i, j);

                    if (sum % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}