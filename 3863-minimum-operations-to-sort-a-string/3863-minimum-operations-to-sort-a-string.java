class Solution {
    public int minOperations(String s) {
        int[] count = new int[26];
        boolean sorted_flag = true;
        int last_min = s.charAt(0) - 'a';
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int curr_min = s.charAt(i) - 'a';
            if (sorted_flag && curr_min < last_min) {
                sorted_flag = false;
            }
            last_min = Math.max(curr_min, last_min);
            count[curr_min]++;
        }
        char min = 'z';
        char max = 'a';

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                min = (char) Math.min(min, 'a' + i);
                max = (char) Math.max(max, 'a' + i);
            }
        }
        if (sorted_flag) {
            return 0;
        } else if (s.charAt(0) == min || s.charAt(n - 1) == max) {
            return 1;
        } else if (n == 2) {
            return -1;
        } else if (s.charAt(0) == max && s.charAt(n - 1) == min
                && count[s.charAt(0) - 'a'] == 1 && count[s.charAt(n - 1) - 'a'] == 1) {
            return 3;
        } else {
            return 2;
        }
    }
}