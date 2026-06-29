class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length,total = m*n;
        int upLeft = 0,upRight = n-1,downLeft =  0,downRight = m-1;
        int count = 0;

        List<Integer> ans = new ArrayList<>();


        while(count < total){
            for(int i=downLeft; i<=upRight && count < total; i++) {
                ans.add(matrix[upLeft][i]);
                count++;
            }
            upLeft++;
            for(int i=upLeft; i<=downRight && count < total; i++){
                ans.add(matrix[i][upRight]);
                count++;
            }
            upRight--;
            for(int i=upRight; i>=downLeft && count < total; i--){
                ans.add(matrix[downRight][i]);
                count++;
            }
            downRight--;
            for(int i=downRight; i>=upLeft && count < total; i--){
                ans.add(matrix[i][downLeft]);
                count++;
            }
            downLeft++;
        }
        return ans;
    }
}