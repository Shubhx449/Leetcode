class Solution {
    public int calculate(String s) {
        int n = s.length();

        Stack<Integer> operands = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);

            if(ch == ' ') continue;


            if(Character.isDigit(ch)){
                if(i > 0 && Character.isDigit(s.charAt(i-1))){
                    operands.add(operands.pop()*10 + (ch - '0'));
                }
                else{
                    operands.add(ch - '0');
                }
            }
            else{
                if(operator.isEmpty()){
                    operator.push(ch);
                }
                else{
                    char top = operator.peek();
                    while ((top == '*' || top == '/') || ((top == '+' || top == '-') && (ch == '+' || ch == '-'))){
                        int num2 = operands.pop(), num1 = operands.pop();

                        switch (top){
                            case '*' :
                                operands.push(num1*num2);
                                break;
                            case '+' :
                                operands.push(num1+num2);
                                break;
                            case '-' :
                                operands.push(num1-num2);
                                break;
                            case '/' :
                                operands.push(num1/num2);
                                break;
                        }
                        
                        operator.pop();
                        if(operator.isEmpty()) break;
                        top = operator.peek();

                    }

                    operator.push(ch);
                }
            }
            
        }
        while (!operator.isEmpty()){
            char top = operator.pop();
            int num2 = operands.pop(), num1 = operands.pop();
            switch (top){
                case '*' :
                    operands.push(num1*num2);
                    break;
                case '+' :
                    operands.push(num1+num2);
                    break;
                case '-' :
                    operands.push(num1-num2);
                    break;
                case '/' :
                    operands.push(num1/num2);
                    break;
            }
        }

        return operands.peek();
    }
}