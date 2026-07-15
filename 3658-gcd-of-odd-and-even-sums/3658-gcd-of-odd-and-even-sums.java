class Solution {
    private int GCD(int low, int high){
        if(low == 0) return high;
        return GCD(high%low,low);
    }

    public int gcdOfOddEvenSums(int n) {
        int odd = 1,even = 2, evenSum = 0,oddSum = 0;

        for(int i=1; i<=n; i++){
            oddSum += odd;
            evenSum += even;

            odd += 2;
            even += 2;
        }
        
        return GCD(oddSum,evenSum);
    }
}