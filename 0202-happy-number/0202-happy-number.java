class Solution {
    private int getNext(int n){
        int count = 0;
        while(n > 0){
            int rem = n%10;
            count += rem*rem;
            n /= 10;
        }
        return count;
    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);

        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }

        return fast == 1;
    }
}