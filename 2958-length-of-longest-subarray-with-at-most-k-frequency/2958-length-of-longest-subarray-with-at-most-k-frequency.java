class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length, maxLen = 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        int left = 0;
        for(int right=0; right<n; right++){
            int num = nums[right];
            map.put(num, map.getOrDefault(num,0) + 1);
            
            while(map.get(num) > k){
                map.put(nums[left],map.get(nums[left])-1);
                left++;
            }
            
            maxLen = Math.max(maxLen, right-left+1);
        }
        
        return maxLen;
    }
}