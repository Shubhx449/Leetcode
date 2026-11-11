class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {

        long c1 = cost1,c2 = cost2,cb = costBoth,n1 = need1,n2 = need2;

        if (c1 + c2 <= cb) {
            return c1 * n1 + c2 * n2;
        } else {
            if (n1 > n2) {
                long diff = n1 - n2;
                if (diff * c1 > diff * cb) {
                    return cb * n1;
                } else {
                    return n2 * cb + diff * c1;
                }
            } else if (n2 > n1) {
                long diff = n2 - n1;
                if (diff * c2 > diff * cb) {
                    return cb * n2;
                } else {
                    return n1 * cb + diff * c2;
                }
            } else {
                return n1 * Math.min(cb, c1 + c2);

            }
        }
    }
}
