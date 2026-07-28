class Solution {
    public String smallestPalindrome(String s) {
        int[] hash = new int[26];

        StringBuilder str = new StringBuilder();

        for (char ch : s.toCharArray()) {
            hash[ch - 'a']++;
        }

        char mid = 0;
        int i = 97;

        for (int ele : hash) {

            int temp = ele / 2;   
            char ch = (char) i;

            for (int j = 0; j < temp; j++) {
                str.append(ch);
            }

            
            if ((ele & 1) != 0) {
                mid = ch;
            }

            i++;
        }

        String left = str.toString();


        if (mid != 0) {
            str.append(mid);
        }


        for (i = left.length() - 1; i >= 0; i--) {
            str.append(left.charAt(i));
        }

        return str.toString();
    }
}