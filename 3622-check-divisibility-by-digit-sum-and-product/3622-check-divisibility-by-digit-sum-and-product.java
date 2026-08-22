class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0, mul = 1,temp = n;

        while(n > 0){
            int rem = n%10;

            sum += rem;
            mul *= rem;

            n /= 10;
        }

        return temp%(sum+mul) == 0;
    }
}