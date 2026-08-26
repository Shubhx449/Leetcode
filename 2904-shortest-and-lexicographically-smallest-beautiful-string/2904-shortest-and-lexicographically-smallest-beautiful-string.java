class Solution {

    private boolean lexicographicalOrder(String a, String b) {
        int n = Math.min(a.length(), b.length());

        for (int i = 0; i < n; i++) {
            if (a.charAt(i) < b.charAt(i))
                return true;

            if (a.charAt(i) > b.charAt(i))
                return false;
        }

        return a.length() < b.length();
    }

    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();

        String ans = "";
        boolean found = false;

        for (int i = 0; i < n; i++) {
            int ones = 0;

            for (int j = i; j < n; j++) {

                if (s.charAt(j) == '1') {
                    ones++;
                }

                if (ones == k) {
                    String curr = s.substring(i, j + 1);

                    if (!found || curr.length() < ans.length()) {
                        ans = curr;
                        found = true;
                    } 
                    else if (curr.length() == ans.length()
                            && lexicographicalOrder(curr, ans)) {
                        ans = curr;
                    }

                    break;
                }
            }
        }

        return ans;
    }
}