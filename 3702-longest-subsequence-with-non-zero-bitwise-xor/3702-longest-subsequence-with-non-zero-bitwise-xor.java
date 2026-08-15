class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int xorAll = 0;
        for (int num : nums) xorAll ^= num;

        if (xorAll != 0) return n;  
        boolean allZero = true;
        for (int num : nums) if (num != 0) allZero = false;
        if (allZero) return 0;
        return n - 1;                // Remove one element
    }
}