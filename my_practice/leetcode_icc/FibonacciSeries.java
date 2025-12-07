package my_practice.leetcode_icc;

public class FibonacciSeries {
    public int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        FibonacciSeries fs = new FibonacciSeries();
        int n = 6; // Example: Find the 6th Fibonacci number
        int result = fs.fibonacci(n);
        System.out.println("The " + n + "th Fibonacci number is: " + result);
    }
}
