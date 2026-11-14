class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();

        for(int i=1; i<n; i++){
            nums.set(i, nums.get(i)+nums.get(i-1));
        }

        int minSum = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            for(int j=l-1; j<r && i+j<n; j++){
                int sum = nums.get(i+j);
                if(i > 0) sum -= nums.get(i-1);

                if(sum < minSum && sum > 0){
                    minSum = sum;
                }
            }
        }
        
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}