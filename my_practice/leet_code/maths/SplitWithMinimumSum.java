package my_practice.leet_code.maths;

public class SplitWithMinimumSum {
    static int solve(int num) {
        // Extract digits
        String s = String.valueOf(num);
        int n = s.length();
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = s.charAt(i) - '0';
        }
        // Sort digits
        java.util.Arrays.sort(digits);

        // Build two numbers by alternate digits
        int num1 = 0, num2 = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                num1 = num1 * 10 + digits[i];
            } else {
                num2 = num2 * 10 + digits[i];
            }
        }
        return num1 + num2;
    }

    public static void main(String[] args) {
//        int num = 4325;
        int num = 687;
        System.out.println(solve(num)); // Output: 59
    }
}
