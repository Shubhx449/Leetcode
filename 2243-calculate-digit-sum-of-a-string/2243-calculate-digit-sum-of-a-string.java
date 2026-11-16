class Solution {
    public String digitSum(String s, int k) {

        while(s.length() > k){
            StringBuilder temp = new StringBuilder();
            
            int len = 0, sum = 0;
            for(int i=0; i<s.length(); i++){
                sum += s.charAt(i)-'0';
                len++;

                if(len == k){
                    temp.append(sum);
                    len = sum = 0;
                }
            }

            if(s.length()%k != 0){
                temp.append(sum);
            }
            
            s = temp.toString();
        }
        
        return s;
    }
}