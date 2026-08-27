class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        if(n == 1) return heights[0];

        Deque<Integer> st = new ArrayDeque<>();
        int[] smaller = new int[n];

        for(int i=0; i<n; i++){
            smaller[i] = n;

            int height = heights[i];
            while (!st.isEmpty() && heights[st.peekLast()] > height){
                smaller[st.removeLast()] = i;
            }

            st.addLast(i);
        }

        st.clear();
        
        int max = 0;
        for(int i=0; i<n; i++){
            int val = -1;
            
            int height = heights[i];
            while (!st.isEmpty() && heights[st.peekLast()] >= height){
                st.removeLast();
            }
            
            if(!st.isEmpty()) val = st.peekLast();
            st.addLast(i);
            
            val = (smaller[i]-val-1)*height;
            
            if(val > max) max = val;
        }
        
        return max;
    }
}