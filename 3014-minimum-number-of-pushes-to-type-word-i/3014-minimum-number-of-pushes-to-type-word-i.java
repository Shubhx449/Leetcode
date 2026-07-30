class Solution {
    public int minimumPushes(String word) {
        int sum = 0, len = word.length(), present = 1;

        while(len > 0){
            int req;
            if(len >= 8){
                req = 8;
                len -= 8;
            }
            else{
                req = len;
                len = 0;
            }

            sum += req*present;
            present++;
        }

        return sum;
    }
}