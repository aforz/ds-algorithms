package my_practice.basics.code_file;

public class PrimesWithout3 {
    static String[] check(int L, int R) {
        java.util.List<String> result = new java.util.ArrayList<>();
        for (int i = L; i <= R; i++) {
            if (isPrime(i) && !containsDigit3(i)) {
                result.add(String.valueOf(i));
            }
        }
        if (result.isEmpty()) {
            return new String[]{"No valid primes found."};
        }
        return result.toArray(new String[0]);
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private static boolean containsDigit3(int n) {
        return String.valueOf(n).contains("3");
    }

    //main method for testing
    public static void main(String[] args) {
        String[] res1 = check(10, 30);
        for (String s : res1) System.out.print(s + " ");
        System.out.println();

        String[] res2 = check(30, 35);
        for (String s : res2) System.out.print(s + " ");
        System.out.println();
    }
}
