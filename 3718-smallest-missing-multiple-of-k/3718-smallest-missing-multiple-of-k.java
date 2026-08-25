class Solution {
    public int missingMultiple(int[] nums, int k) {
        boolean[] freq = new boolean[100+1];

        for (int num : nums) {
            freq[num] = true;
        }

        int mul = 1, temp = k;
        while (temp <= 100 && freq[temp]) {
            temp = mul*k;
            mul++;
        }

        return temp;
    }
}