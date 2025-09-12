package my_practice.leet_code.maths;

public class LargestPrimeNumber {
    static int solve(int n) {
        int result = -1;
        while (n % 2 == 0) {
            result = 2;
            n = n / 2;
        }
        for (int i = 3; i * i <= n; i = i + 2) {
            if (n % i == 0) {
                result = i;
                n = n / i;
            }
        }
        if (n > 2) {
            result = n;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 15;
        int result = solve(n);
        System.out.println(result);
    }

}
