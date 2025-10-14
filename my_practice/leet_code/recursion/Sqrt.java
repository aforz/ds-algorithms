package my_practice.leet_code.recursion;

public class Sqrt {
    public int mySqrt(int x) {
        if (x < 2) return x;

        int left = 1, right = x / 2, ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // Use long to avoid integer overflow
            long sq = (long) mid * mid;
            if (sq == x) {
                return mid;
            } else if (sq < x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.mySqrt(8)); // Output: 2
        System.out.println(sqrt.mySqrt(4)); // Output: 2
        System.out.println(sqrt.mySqrt(2147395599)); // Output: 46339
    }
}
