class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(i);
            }
            else{
                if(!st.isEmpty() && s.charAt(st.peek()) == '('){
                    st.pop();
                }
                else{
                    st.push(i);
                }
            }
        }

        int maxLen = 0;
        int i = n;

        while(!st.isEmpty()){
            int temp = st.pop();

            maxLen = Math.max(maxLen, i-temp-1);
            i = temp;
        }

        return Math.max(maxLen, i);
    }
}