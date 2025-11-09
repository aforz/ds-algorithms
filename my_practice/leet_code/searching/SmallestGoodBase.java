package my_practice.leet_code.searching;

public class SmallestGoodBase {
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);
        int max_m = (int) (Math.log(num) / Math.log(2));
        for (int m = max_m; m >= 1; --m) {
            long left = 2, right = (long) Math.pow(num, 1.0 / m) + 1;
            while (left <= right) {
                long k = left + (right - left) / 2;
                long sum = 1, curr = 1;
                for (int i = 1; i <= m; ++i) {
                    curr *= k;
                    sum += curr;
                    if (sum > num) break;
                }
                if (sum == num) return Long.toString(k);
                if (sum < num) left = k + 1;
                else right = k - 1;
            }
        }
        return Long.toString(num - 1);
    }

    public static void main(String[] args) {
        SmallestGoodBase solver = new SmallestGoodBase();
        System.out.println(solver.smallestGoodBase("13"));    // Output: "3"
        System.out.println(solver.smallestGoodBase("4681"));  // Output: "8"
    }
}