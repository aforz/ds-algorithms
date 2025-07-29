package com.leet_code;

public class MySqrt {
    public static int mySqrt(int x) {
        if (x < 2) return x;

        int left = 1, right = x / 2;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long midSquared = (long) mid * mid;

            if (midSquared == x) {
                return mid;
            } else if (midSquared < x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    // Example usage
    public static void main(String[] args) {
        System.out.println(mySqrt(4)); // Output: 2
        System.out.println(mySqrt(8)); // Output: 2
        System.out.println(mySqrt(0)); // Output: 0
        System.out.println(mySqrt(1)); // Output: 1
        System.out.println(mySqrt(2147395599)); // Output: 46339
    }
}
