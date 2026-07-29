class Solution {

    private static final long LIMIT = 1_000_001L;

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    private long combination(int n, int r) {
        if (r < 0 || r > n) return 0;
        r = Math.min(r, n - r);

        long res = 1;

        for (int i = 1; i <= r; i++) {
            long num = n - r + i;
            long den = i;

            long g = gcd(num, den);
            num /= g;
            den /= g;

            g = gcd(res, den);
            res /= g;
            den /= g;

            if (res > LIMIT / num)
                return LIMIT;

            res *= num;
            res /= den;

            if (res > LIMIT)
                return LIMIT;
        }

        return res;
    }

    private long countWays(int[] freq) {

        int total = 0;
        for (int x : freq)
            total += x;

        long ways = 1;

        for (int x : freq) {
            if (x == 0) continue;

            long c = combination(total, x);

            if (ways > LIMIT / c)
                return LIMIT;

            ways *= c;

            if (ways > LIMIT)
                return LIMIT;

            total -= x;
        }

        return ways;
    }

    public String smallestPalindrome(String s, int k) {

        int[] freq = new int[26];

        for (char ch : s.toCharArray())
            freq[ch - 'a']++;

        char mid = 0;

        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1)
                mid = (char) ('a' + i);
            freq[i] /= 2;
        }

        if (countWays(freq) < k)
            return "";

        StringBuilder left = new StringBuilder();

        int len = s.length() / 2;

        for (int pos = 0; pos < len; pos++) {

            for (int ch = 0; ch < 26; ch++) {

                if (freq[ch] == 0)
                    continue;

                freq[ch]--;

                long ways = countWays(freq);

                if (ways >= k) {
                    left.append((char) ('a' + ch));
                    break;
                }

                k -= ways;
                freq[ch]++;
            }
        }

        StringBuilder ans = new StringBuilder();

        ans.append(left);

        if (mid != 0)
            ans.append(mid);

        ans.append(new StringBuilder(left).reverse());

        return ans.toString();
    }
}