class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = 101, max = 0;

        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
            if(max < num) max = num;
            if(min > num) min = num;
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=min+1; i<max; i++){
            if(!set.contains(i)) ans.add(i);
        }

        return ans;
    }
}