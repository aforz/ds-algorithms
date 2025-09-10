package my_practice.leet_code.sortings;

public class MinSumTwoNumbers {
    public static int minSum(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        // Manual selection sort (ascending order)
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            // Swap
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }

        // Build two numbers as strings (to avoid integer overflow)
        String num1 = "", num2 = "";
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) num1 += arr[i];
            else num2 += arr[i];
        }

        // Manual string-to-int addition
        return addStrings(num1, num2);
    }

    // Helper to add two non-negative numbers as strings
    private static int addStrings(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, carry = 0, res = 0, factor = 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            res += (sum % 10) * factor;
            factor *= 10;
            carry = sum / 10;
        }
        return res;
    }

    // Example usage
    public static void main(String[] args) {
        System.out.println(minSum(new int[]{6, 8, 4, 5, 2, 3})); // Output: 604
        System.out.println(minSum(new int[]{5, 3, 0, 7, 4}));   // Output: 82
        System.out.println(minSum(new int[]{0}));           // Output: 0
    }
}
