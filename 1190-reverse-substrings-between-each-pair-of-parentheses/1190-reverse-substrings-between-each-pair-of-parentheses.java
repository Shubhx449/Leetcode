class Solution {
    public String reverseParentheses(String s) {
        Stack<String> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                StringBuilder temp = new StringBuilder();

                while (!st.peek().equals("(")) {
                    StringBuilder pop = new StringBuilder(st.pop());

                    if(pop.length() == 1){
                        temp.append(pop);
                    }
                    else{
                        temp.append(pop.reverse());
                    }
                }

                st.pop();
                st.push(temp.toString());

            } else {
                st.push(ch + "");
            }
        }

        StringBuilder ans = new StringBuilder();

        for(String ele : st){
            ans.append(ele);
        }

        return ans.toString();
    }
}