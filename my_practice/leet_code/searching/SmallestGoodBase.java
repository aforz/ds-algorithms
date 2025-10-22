package my_practice.leet_code.searching;

import java.math.BigInteger;

public class SmallestGoodBase {
    public String smallestGoodBase(String n_str) {
        long n = Long.parseLong(n_str);
        int max_m = (int) (Math.log(n + 1) / Math.log(2)); // maximum possible m

        for (int m = max_m; m >= 2; m--) {
            long left = 2, right = (long) Math.pow(n, 1.0 / m) + 1;
            while (left <= right) {
                long k = left + (right - left) / 2;
                BigInteger sum = BigInteger.ONE;
                BigInteger base = BigInteger.ONE;
                for (int i = 0; i < m; i++) {
                    base = base.multiply(BigInteger.valueOf(k));
                    sum = sum.add(base);
                }
                BigInteger nBI = BigInteger.valueOf(n);
                int cmp = sum.compareTo(nBI);
                if (cmp == 0) return Long.toString(k);
                else if (cmp < 0) left = k + 1;
                else right = k - 1;
            }
        }
        return Long.toString(n - 1);
    }

    public static void main(String[] args) {
        SmallestGoodBase sgb = new SmallestGoodBase();
        System.out.println(sgb.smallestGoodBase("13"));    // Output: 3
        System.out.println(sgb.smallestGoodBase("4681"));  // Output: 8
    }
}
