class Solution {
    private int maxRectangle(int[] heights) {
        int n = heights.length;

        Stack<Integer> st = new Stack<>();

        int max = 0;
        for(int i=0; i<=n; i++){
            int height = i == n ? 0 : heights[i];

            while(!st.isEmpty() && heights[st.peek()] > height){
                int h = heights[st.pop()];

                int left = st.isEmpty() ? -1 : st.peek();

                int width = i-left-1;

                max = Math.max(max, width*h);
            }

            if(i < n){
                st.push(i);
            }
        }
        
        return max;

    }

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        int[] height = new int[n];

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }

            max = Math.max(max, maxRectangle(height));
        }

        return max;
    }
}