class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length, m = n - k + 1;

        Deque<Integer> q = new ArrayDeque<>();
        int[] ans = new int[m];

        int j = 0;
        for (int i = 0; i < n; i++) {
            if (q.isEmpty()) {
                q.addLast(i);
            } else {
                while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                    q.removeLast();
                }
                q.addLast(i);
            }

            while (q.peekFirst() < j) {
                q.removeFirst();
            }

            if (i >= k - 1) {
                ans[j++] = nums[q.peekFirst()];
            }
        }

        return ans;
    }
}