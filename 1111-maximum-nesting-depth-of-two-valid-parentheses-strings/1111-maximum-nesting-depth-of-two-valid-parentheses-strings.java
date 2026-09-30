class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();

        int[] ans = new int[n];

        int i = 0;
        boolean in = true, out = true;
        for(int ch : seq.toCharArray()){
            if(ch == '('){
                ans[i++] = in ? 0 : 1;
                in = !in;
            }else{
                ans[i++] = out ? 0 : 1;
                out = !out;
            }
        }

        return ans;
        
    }
}