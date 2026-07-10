class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = i;
            arr[i][1] = nums[i];
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));

        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[arr[i][0]] = i;
        }

        int[] r = new int[n];
        int right = 0;
        for (int i = 0; i < n; i++) {
            if (right < i) right = i;
            while (right + 1 < n && arr[right + 1][1] - arr[i][1] <= maxDiff) {
                right++;
            }
            r[i] = right;
        }

        int[] comp = new int[n];
        comp[0] = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i][1] - arr[i - 1][1] <= maxDiff) {
                comp[i] = comp[i - 1];
            } else {
                comp[i] = comp[i - 1] + 1;
            }
        }

        int LOG = 1;
        while ((1 << LOG) < n) LOG++;
        LOG++;

        int[][] jump = new int[LOG][n];
        jump[0] = r;
        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                jump[k][i] = jump[k - 1][jump[k - 1][i]];
            }
        }

        int[] answer = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int u = queries[q][0], v = queries[q][1];
            int pu = pos[u], pv = pos[v];

            if (pu == pv) {
                answer[q] = 0;
                continue;
            }
            if (pu > pv) {
                int t = pu; pu = pv; pv = t;
            }

            if (comp[pu] != comp[pv]) {
                answer[q] = -1;
                continue;
            }

            int cur = pu, steps = 0;
            for (int k = LOG - 1; k >= 0; k--) {
                if (jump[k][cur] < pv) {
                    cur = jump[k][cur];
                    steps += (1 << k);
                }
            }
            steps += 1;
            answer[q] = steps;
        }

        return answer;
    }
}