class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0; i<n; i++){
            for(int low = 0,high = n-1;high>low;high--,low++){
                int temp = matrix[i][high];
                matrix[i][high] = matrix[i][low];
                matrix[i][low] = temp;
            }
        }
    }
}