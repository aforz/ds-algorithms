package my_practice.leet_code.Bit_Manipulations;

public class SingleNumber {
    // Returns the element that appears only once, while others appear three times
    public static int solve(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 2};
        System.out.println(solve(nums)); // Output: 3
    }
}

/*Given an integer array nums where every element appears three times except for one, which appears exactly once.
Find the single element and return it.
You must implement a solution with a linear runtime complexity and use only constant extra space.

Input 1:
nums = [2,2,3,2]
Output 1:
3
Explanation 1:
3 is present only once.

Input 2:
nums = [0,1,0,1,0,1,99]
Output 2:
99

Constraints:
1 <= nums.length <= 3*104
-231 <= nums[i] <= 231-1*/