class Solution {
    public int reverseDegree(String s) {
        int n = s.length(), sum = 0;

        for(int i=1; i<=n; i++){
            sum += (i * (26 - (s.charAt(i-1) - 'a')));
        }

        return sum;
    }
}