package my_practice.leet_code.maths;

public class PrintPrimeFactors {
    public static void printPrimeFactors(int n) {
        // Print the number of 2s that divide n
        while (n % 2 == 0) {
            System.out.print(2 + " ");
            n /= 2;
        }

        // n must be odd at this point. So we can skip one element (i += 2)
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            // While i divides n, print i and divide n
            while (n % i == 0) {
                System.out.print(i + " ");
                n /= i;
            }
        }

        // If n is a prime number greater than 2
        if (n > 2) {
            System.out.print(n);
        }
    }

    public static void main(String[] args) {
        int n = 315;
        printPrimeFactors(n);
    }
}
