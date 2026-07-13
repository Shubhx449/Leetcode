class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();

        int temp = low,digit = 1,num = 0,add  = 0;
        while(temp > 0){
            num *= 10;
            num += digit;
            digit++;

            add *= 10;
            add += 1;

            temp /= 10;
        }

        int pref = num;
        
        while(low > num){
            if(num%10 == 9){
                int lstDigit = pref%10;
                lstDigit++;

                pref *= 10;
                pref += lstDigit;

                num = pref;
                
                add *= 10;
                add++;
            }else{
                num += add;
            }
        }
        
        while(num <= high){
            ans.add(num);
            if(num%10 == 9){
                int lstDigit = pref%10;
                lstDigit++;

                pref *= 10;
                pref += lstDigit;

                num = pref;
                
                add *= 10;
                add++;
            }else{
                num += add;
            }
        }

        return ans;

    }
}