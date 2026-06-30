class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();

        while(!seen.contains(n)){
            if(n == 1) return true;
            seen.add(n);
 
            int count = 0;
            while(n > 0){
                int rem = n%10;
                count += rem*rem;
                n /= 10;
            }
            n = count;
        }

        return false;
    }
}