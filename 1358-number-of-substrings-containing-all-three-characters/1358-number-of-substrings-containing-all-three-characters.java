class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] hash = new int[3];
        hash[0] = hash[1] = hash[2] = -1;
        int count = 0,min;
        for(int i=0; i<n; i++){
            hash[s.charAt(i) - 'a'] = i;
           min = (hash[0] < hash[1])
                ? ((hash[0] < hash[2]) ? hash[0] : hash[2])
                : ((hash[1] < hash[2]) ? hash[1] : hash[2]);
            count += (min+1);
        } 
        return count;
    }
}