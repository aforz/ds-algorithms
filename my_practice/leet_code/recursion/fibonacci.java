package my_practice.leet_code.recursion;

import java.util.HashMap;
import java.util.Map;

public class fibonacci {
    // Original recursive method (inefficient for large values)
    public int fib(int n) {
        if (n <= 0){
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
    
    // Memoized version for better performance
    private Map<Integer, Integer> memo = new HashMap<>();
    
    public int fibMemoized(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        
        // Check if we've already calculated this value
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        
        // Calculate and store the result
        int result = fibMemoized(n - 1) + fibMemoized(n - 2);
        memo.put(n, result);
        return result;
    }
    
    // Iterative version (most efficient)
    public int fibIterative(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        
        int prev = 0;      // fib(0)
        int current = 1;   // fib(1)
        int result = 0;
        
        // Iterate from 2 to n to build up the sequence
        for (int i = 2; i <= n; i++) {
            result = prev + current;
            prev = current;
            current = result;
        }
        
        return current;
    }

    // For testing
    public static void main(String[] args) {
        fibonacci fibonacci = new fibonacci();
        int n1 = 5;
        System.out.println("Fibonacci of " + n1 + " is: " + fibonacci.fib(n1)); // Output: 5
        System.out.println("Fibonacci (memoized) of " + n1 + " is: " + fibonacci.fibMemoized(n1)); // Output: 5
        System.out.println("Fibonacci (iterative) of " + n1 + " is: " + fibonacci.fibIterative(n1)); // Output: 5
        
        int n2 = 10;
        System.out.println("Fibonacci of " + n2 + " is: " + fibonacci.fib(n2)); // Output: 55
        System.out.println("Fibonacci (memoized) of " + n2 + " is: " + fibonacci.fibMemoized(n2)); // Output: 55
        System.out.println("Fibonacci (iterative) of " + n2 + " is: " + fibonacci.fibIterative(n2)); // Output: 55
        
        // Test with a larger number (would be very slow with the original method)
        int n3 = 40;
        
        long startMemo = System.currentTimeMillis();
        int resultMemo = fibonacci.fibMemoized(n3);
        long endMemo = System.currentTimeMillis();
        System.out.println("Fibonacci (memoized) of " + n3 + " is: " + resultMemo); 
        System.out.println("Time taken for memoized n=" + n3 + ": " + (endMemo - startMemo) + " ms");
        
        long startIter = System.currentTimeMillis();
        int resultIter = fibonacci.fibIterative(n3);
        long endIter = System.currentTimeMillis();
        System.out.println("Fibonacci (iterative) of " + n3 + " is: " + resultIter); 
        System.out.println("Time taken for iterative n=" + n3 + ": " + (endIter - startIter) + " ms");
    }
}
