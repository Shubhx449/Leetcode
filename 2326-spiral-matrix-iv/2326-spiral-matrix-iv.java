class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];

        int upperLeft = 0, upperRight = n-1, lowerLeft = 0, lowerRight = m-1;

        int count = m*n, total = 0;
        while(total < count){
            for(int i=lowerLeft; i<=upperRight && total < count; i++){
                if(head != null){
                    ans[upperLeft][i] = head.val;
                    head = head.next;
                }else{
                    ans[upperLeft][i] = -1;
                }

                total++;
            }
            upperLeft++;

            for(int i=upperLeft; i<=lowerRight && total < count; i++){
                if(head != null){
                    ans[i][upperRight] = head.val;
                    head = head.next;
                }else{
                    ans[i][upperRight] = -1;
                }

                total++;
            }
            upperRight--;

            for(int i=upperRight; i>=lowerLeft && total < count; i--){
                if(head != null){
                    ans[lowerRight][i] = head.val;
                    head = head.next;
                }else{
                    ans[lowerRight][i] = -1;
                }

                total++;
            }
            lowerRight--;

            for(int i=lowerRight; i>=upperLeft && total < count; i--){
                if(head != null){
                    ans[i][lowerLeft] = head.val;
                    head = head.next;
                }else{
                    ans[i][lowerLeft] = -1;
                }

                total++;
            }
            lowerLeft++;
        }

        return ans;
    }
}