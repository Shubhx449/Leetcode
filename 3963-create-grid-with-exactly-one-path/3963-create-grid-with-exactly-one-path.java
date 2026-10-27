class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans = new String[m];
        for(int j=0;j<m;j++){
            StringBuilder str = new StringBuilder();
            for(int i=0;i<n;i++){
                if(j==0 || i==n-1) str.append('.');
                else str.append('#');
            }
            ans[j] = str.toString();
        }
        return ans;
    }
}