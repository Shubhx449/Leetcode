class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int min = 0, max = 0;

        for(int i=0; i<n; i++){
            int num = nums[i];
            
            if(nums[min] > num){
                min = i;
            }

            if(nums[max] < num){
                max = i;
            }
        }

        if(min > max){
            int temp = min;
            min = max;
            max = temp;
        } 
        
        n--;

        int steps1 = (min+1)+(n-max+1), steps2 = max+1, steps3 = n-min+1;

        return Math.min(steps1, Math.min(steps2, steps3));
    }
}