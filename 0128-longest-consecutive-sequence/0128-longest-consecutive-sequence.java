class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        int max = 1;
        for(int i=0; i<n; i++){
            if(set.contains(nums[i]-1)) continue;
            int count = 0, next = nums[i];
            while(set.contains(next)){
                count++;
                set.remove(next++);
            }
            if(max < count) max = count;
        }

        return max;
    }
}