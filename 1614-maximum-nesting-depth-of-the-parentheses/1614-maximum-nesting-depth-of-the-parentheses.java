class Solution {
    public int maxDepth(String s) {
        int len = 0, maxLen = 0;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                len++;
            }
            else if(ch == ')'){
                len--;
            }

            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}