class Solution {
    public int calculate(String s) {
        int n = s.length();

        Stack<Integer> st = new Stack<>();
        Stack<Boolean> flag = new Stack<>();

        boolean sign = true;
        int sum = 0;

        x: for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (Character.isWhitespace(ch)) {
                continue;
            }

            if (Character.isDigit(ch)) {
                int digit = 0;
                while (Character.isDigit(ch)) {
                    digit = digit * 10 + (ch - '0');

                    if (i == n - 1) {
                        if (sign) {
                            sum += digit;
                        } else {
                            sum -= digit;
                        }

                        break x;
                    }

                    i++;
                    ch = s.charAt(i);
                }

                i--;

                if (sign) {
                    sum += digit;
                } else {
                    sum -= digit;
                }

            } else {
                if (ch == '(') {
                    st.push(sum);
                    flag.push(sign);
                    sign = true;
                    sum = 0;
                } else if (ch == ')') {
                    if (flag.pop()) {
                        sum += st.pop();
                    } else {
                        sum = st.pop() - sum;
                    }
                } else
                    sign = ch == '+';
            }

        }

        return sum;
    }
}

//System.out.println(ch +" " +sum +" "+flag+" "+st+"  "+sign);