class Solution {
    public boolean uniformArray(int[] nums) {
        int odd = Integer.MAX_VALUE;

        for (int num : nums) {
            if ((num & 1) == 1) {
                odd = Math.min(odd, num);
            }
        }

        if (odd == Integer.MAX_VALUE) {
            return true;
        }

        for (int num : nums) {
            if ((num & 1) == 0 && num <= odd) {
                return false;
            }
        }

        return true;
    }
}