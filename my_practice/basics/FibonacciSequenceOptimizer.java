package my_practice.basics;

public class FibonacciSequenceOptimizer {
    static java.util.Map<Integer, Long> memo = new java.util.HashMap<>();

    static long solve(int n) {
        if (n <= 1) return n;
        if (memo.containsKey(n)) return memo.get(n);

        long result = solve(n - 1) + solve(n - 2);
        memo.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter count to create Fibonacci sequence: ");
        int num = sc.nextInt();
        System.out.print("0 1 ");
        for (int i = 2; i < num; i++) {
            System.out.print(solve(i) + " ");
        }
        sc.close();
    }
}
