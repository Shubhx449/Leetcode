class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        int[] arr = new int[n];

        int min = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (min > nums[i])
                min = nums[i];

            arr[i] = min;
        }

        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            if (max < nums[i])
                max = nums[i];

            if (max - arr[i] <= k) {
                return i;
            }
        }

        return -1;
    }
}