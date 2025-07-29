package com.leet_code;

import java.util.Arrays;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry = 1; // Start by adding one

        for (int i = n - 1; i >= 0; i--) {
            int newDigit = digits[i] + carry;
            if (newDigit == 10) {
                digits[i] = 0;
                carry = 1;
            } else {
                digits[i] = newDigit;
                carry = 0;
                break;
            }
        }

        if (carry == 1) {
            // All digits were 9, need to add one extra digit at the front
            int[] result = new int[n + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, n);
            return result;
        }

        return digits;
    }

    // Example usage
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));     // [1, 2, 4]
        System.out.println(Arrays.toString(plusOne(new int[]{4, 3, 2, 1})));   // [4, 3, 2, 2]
        System.out.println(Arrays.toString(plusOne(new int[]{9})));         // [1, 0]
        System.out.println(Arrays.toString(plusOne(new int[]{9, 8, 9})));     // [1, 0, 0, 0]
    }
}
