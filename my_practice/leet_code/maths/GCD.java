package my_practice.leet_code.maths;

public class GCD {
    static int gcd(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        while (b > 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }

    public static void main(String[] args) {
        int a = 20, b = 28;
        int result = gcd(a, b);
        System.out.println(result);
    }
}
