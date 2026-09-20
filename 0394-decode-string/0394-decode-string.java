class Solution {
    public String decodeString(String s) {
        int n = s.length();

        Stack<Integer> num = new Stack<>();
        Stack<String> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                if (i > 0 && Character.isDigit(s.charAt(i - 1))) {
                    num.push(10 * num.pop() + (ch - '0'));
                } else {
                    num.push(ch - '0');
                }
            } else {
                if (ch == ']') {
                    StringBuilder temp = new StringBuilder();

                    String top = st.pop();
                    while (!top.equals("[")) {
                        temp.insert(0, top);
                        top = st.pop();
                    }

                    int j = num.pop();

                    StringBuilder x = new StringBuilder(temp);
                    while (j-- > 1) {
                        temp.append(x);
                    }

                    st.push(temp.toString());
                } else {
                    st.push("" + ch);
                }

            }
        }

        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.insert(0, st.pop());
        }

        return ans.toString();
    }
}