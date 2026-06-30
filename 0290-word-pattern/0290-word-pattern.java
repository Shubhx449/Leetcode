class Solution {
    public boolean wordPattern(String pattern, String s) {
        int n = pattern.length();

        
        HashMap<String,Character> map = new HashMap<>();
        String[] map1 = new String[26];
        String[] words = s.split(" ");

        if(words.length != n) return false;

        for(int i=0; i<words.length; i++){
            char ch = pattern.charAt(i) ;

            if(!map.containsKey(words[i])) map.put(words[i],ch);
            else{
                if(map.get(words[i]) != ch) return false;
            }

            int j = ch - 'a';

            if(map1[j] == null) map1[j] = words[i];
            else{
                if(!map1[j].equals(words[i])) return false;
            }
        }
        return true;
    }
}