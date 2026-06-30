class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        int max = 1;
        for(int num : set){
            if(set.contains(num-1)) continue; 
            int count = 0, next = num;
            while(set.contains(next++)){
                count++;
            }
            if(max < count) max = count;
        }

        return max;
    }
}
