class Solution {
    private final int[][] dirs = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

    private int count(int[][] board, int i, int j){
        int count = 0;
        for(int[] dir : dirs){
            int r = i+dir[0], c = j+dir[1];
            if((r>=0 && c>=0 && r<board.length && c<board[0].length) && (board[r][c] == 1 || board[r][c] == 2)) count++;
        }
        return count;
    }
    public void gameOfLife(int[][] board) {
        int m = board.length,n = board[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int count = count(board,i,j);
                if(board[i][j] == 0){
                    if(count == 3) board[i][j] = -1;
                }
                else if(count < 2 || count > 3) board[i][j] = 2;
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == -1) board[i][j] = 1;
                if(board[i][j] == 2)  board[i][j] = 0;
            }
        }
    }
}