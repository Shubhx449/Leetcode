class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int distance = 0;

        boolean flag = true;
        for(int ele1 : arr1){
            flag = true;
            for(int ele2 : arr2){
                if(Math.abs(ele1 - ele2) <= d){
                    flag = false;
                    break;
                }
            }

            if(flag){
                distance++;
            }
        }

        return distance;
    }
}