class Solution {
    public long sumAndMultiply(int n) {
        long num = 0, sum = 0, mul = 1;
        while(n > 0){
            long rem = n%10;

            if(rem > 0){
                sum += rem;
                num += rem*mul;
                mul *= 10;
            }

            n /= 10;
        }

        return num*sum;
    }
}