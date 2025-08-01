package my_practice.basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimesWithout3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter L: ");
        int L = scanner.nextInt();
        System.out.print("Enter R: ");
        int R = scanner.nextInt();
        List<Integer> result = primesWithout3(L, R);
        System.out.println("Primes between " + L + " and " + R + " without digit '3':");
        for (int prime : result) {
            System.out.print(prime + " ");
        }
    }

    private static List<Integer> primesWithout3(int L, int R) {
        List<Integer> primes = new ArrayList<>();
        for (int i = L; i <= R; i++) {
            if (isPrime(i) && !containsDigit3(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private static boolean containsDigit3(int n) {
        return Integer.toString(n).contains("3");
    }
}
