package my_practice.leet_code.Array;

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

/*You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
Increment the large integer by one and return the resulting array of digits.

Example 1:
Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].

Example 2:
Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].

Example 3:
Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].

Constraints:
1 <= digits.length <= 100
0 <= digits[i] <= 9
digits does not contain any leading 0's.*/