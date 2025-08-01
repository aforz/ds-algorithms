package my_practice.basics.code_file;

public class PrimNoGenerator {

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int input = sc.nextInt();
        int[] primes = solve(input);
        if (primes.length == 0) {
            System.out.println("No valid primes found.");
        } else {
            for (int prime : primes) {
                System.out.print(prime + " ");
            }
        }
    }

    static int[] solve(int input) {
        java.util.List<Integer> list = new java.util.ArrayList<>();
        for (int i = 2; i <= input; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
