package my_practice.leet_code.searching;

public class DivideWithoutBitManipulation {
    public int divide(int dividend, int divisor) {
        // Handle overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Work with positive numbers, track sign
        boolean negative = (dividend < 0) ^ (divisor < 0);
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        int result = 0;
        while (dvd >= dvs) {
            dvd -= dvs;
            result++;
        }

        return negative ? -result : result;
    }

    public static void main(String[] args) {
        DivideWithoutBitManipulation solver = new DivideWithoutBitManipulation();
        System.out.println(solver.divide(10, 3));    // Output: 3
        System.out.println(solver.divide(7, -3));    // Output: -2
        System.out.println(solver.divide(-2147483648, -1)); // Output: 2147483647
    }
}
