class Solution {
    private int GCD(int high, int low){
        return low == 0 ? high : GCD(low,high % low);
    }

    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] pref = new int[n];

        int max = nums[0];

        int idx = 0;
        for(int num : nums){
            if(max < num) max = num;
            pref[idx++] = GCD(max, num);
        }

        Arrays.sort(pref);

        long sum = 0;
        for(int i=0,j=n-1; j>i; i++,j--){
            sum += (long) GCD(pref[j], pref[i]);
        
        }

        return sum;
    }
}