class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] maps = new char[128];
        char[] mapt = new char[128];
        int n = s.length();

        for(int i=0; i<n; i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (maps[c1] == '\0' && mapt[c2] == '\0') {
                maps[c1] = c2;
                mapt[c2] = c1;
            }
            else if (maps[c1] != c2 || mapt[c2] != c1) return false;
        }

        return true;
    }
}

