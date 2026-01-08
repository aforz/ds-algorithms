package my_practice.leet_code.Dynamic_Programing;

import java.util.Arrays;

public class MaximumScore {
    public int maximumScore(int[] nums, int[] multipliers) {
        // For Right Pointer
        int n = nums.length;
        // Number of Operations
        int m = multipliers.length;
        int[][] dp = new int[m + 1][m + 1];

        for (int i = 0; i <= m; i++)
            Arrays.fill(dp[i], 0);

        for (int op = m - 1; op >= 0; op--) {
            for (int left = op; left >= 0; left--) {
                dp[op][left] = Math.max(multipliers[op] * nums[left] + dp[op + 1][left + 1],
                        multipliers[op] * nums[n - 1 - (op - left)] + dp[op + 1][left]);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        MaximumScore ms = new MaximumScore();
        int[] nums = {1, 2, 3};
        int[] multipliers = {3, 2, 1};
        System.out.println(ms.maximumScore(nums, multipliers)); // Output: 14
    }
}
