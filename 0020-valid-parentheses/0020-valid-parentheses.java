class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int i = 0;
        while(i!=s.length()){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                st.push(s.charAt(i));
            else{
                if(st.isEmpty())
                    return false;
                else{
                    if(st.peek() == '(' && s.charAt(i) !=')')
                        return false;
                    else if(st.peek() == '[' && s.charAt(i) !=']')
                        return false;
                    else if(st.peek() == '{' && s.charAt(i) !='}')
                        return false;
                    else
                        st.pop();
                }
            }
            i++;
        }
        return st.isEmpty();
    }
}
