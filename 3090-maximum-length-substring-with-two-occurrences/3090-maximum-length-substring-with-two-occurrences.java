class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        byte[] freq = new byte[26];
        
        int j=0,maxLen = 0;
        for(int i=0; i<n; i++){
            int idx = s.charAt(i)-'a';
            freq[idx]++;
            
            while(freq[idx] > 2){
                freq[s.charAt(j)-'a']--;
                j++;
            }
            
            maxLen = Math.max(maxLen,i-j+1);
        }
        
        return maxLen;
    }
}