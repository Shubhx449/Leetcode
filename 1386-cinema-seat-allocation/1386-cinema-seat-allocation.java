class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] p : reservedSeats) {
            map.computeIfAbsent(p[0], k -> new ArrayList<>()).add(p[1]);
        }

        int ans = (n - map.size()) * 2;

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            Set<Integer> temp = new HashSet<>();

            for (int num : entry.getValue()) {
                temp.add(num);
            }

            if (!temp.contains(2) && !temp.contains(3)
                    && !temp.contains(4) && !temp.contains(5)) {
                temp.add(4);
                temp.add(5);
                ans++;
            }

            if (!temp.contains(4) && !temp.contains(5)
                    && !temp.contains(6) && !temp.contains(7)) {
                temp.add(6);
                temp.add(7);
                ans++;
            }

            if (!temp.contains(6) && !temp.contains(7)
                    && !temp.contains(8) && !temp.contains(9)) {
                ans++;
            }
        }

        return ans;
    }
}