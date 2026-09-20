class Solution {
    public String simplifyPath(String path) {
        int n = path.length();

        String[] words = path.split("/+");
        Stack<String> st = new Stack<>();

        
        for (int i=1; i<words.length; i++) {
            String word = words[i];

            if (word.equals(".")) {
                continue;
            }
            if (word.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(word);
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!st.isEmpty()) {
            ans.insert(0, (st.pop() + "/"));
        }

        if(ans.length() > 0){
            ans.deleteCharAt(ans.length()-1);
        }

        ans.insert(0, "/");
        
        return ans.toString();
    }
}
