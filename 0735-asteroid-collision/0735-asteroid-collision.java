class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;

        Stack<Integer> st = new Stack<>();

        for(int asteroid : asteroids){
            if(st.isEmpty()){
                st.push(asteroid);
            }
            else{
                if(st.peek() < 0){
                    st.push(asteroid);
                }
                else{
                    if(asteroid > 0){
                        st.push(asteroid);
                    }
                    else{
                        while (!st.isEmpty() && st.peek() > 0 && -asteroid > st.peek()){
                            st.pop();
                        }

                        if(st.isEmpty() || st.peek() < 0){
                            st.push(asteroid);
                        }
                        else if(st.peek() == -asteroid){
                            st.pop();
                        }
                    }
                }
            }
        }

        int[] ans = new int[st.size()];

        int i = 0;
        for(int ele : st){
            ans[i++] = ele;
        }

        return ans;
    }
}