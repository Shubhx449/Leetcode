class Solution {
    public boolean canAliceWin(int n) {
        int count = 0, remove = 10;

        while(n >= remove){
            n -= remove--;
            count++;
        }

        return (count&1) != 0;
    }
}