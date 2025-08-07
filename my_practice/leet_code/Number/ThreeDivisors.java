package my_practice.leet_code.Number;

public class ThreeDivisors {
    public boolean isThree(int n) {
        // Find square root of n
        int sqrt = (int)Math.sqrt(n);
        if (sqrt * sqrt != n) return false; // n must be a perfect square

        // Check if sqrt is prime
        if (sqrt < 2) return false;
        for (int i = 2; i * i <= sqrt; i++) {
            if (sqrt % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ThreeDivisors td = new ThreeDivisors();
        System.out.println(td.isThree(4));  // Output: true (4 has exactly three divisors: 1, 2, 4)
        System.out.println(td.isThree(9));  // Output: true (9 has exactly three divisors: 1, 3, 9)
        System.out.println(td.isThree(10)); // Output: false (10 has four divisors: 1, 2, 5, 10)
        System.out.println(td.isThree(16)); // Output: false (16 has five divisors: 1, 2, 4, 8, 16)
    }
}

/*Given an integer n, return true if n has exactly three positive divisors. Otherwise, return false.
An integer m is a divisor of n if there exists an integer k such that n = k * m.

Example 1:
Input: n = 2
Output: false
Explantion: 2 has only two divisors: 1 and 2.

Example 2:
Input: n = 4
Output: true
Explantion: 4 has three divisors: 1, 2, and 4.

Constraints:
1 <= n <= 104*/