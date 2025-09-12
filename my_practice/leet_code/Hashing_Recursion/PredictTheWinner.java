package my_practice.leet_code.Hashing_Recursion;

public class PredictTheWinner {
    static boolean solve(int[] nums) {
        int n = nums.length;
        // dp[i][j]: max score player 1 can achieve more than player 2 from nums[i..j]
        Integer[][] dp = new Integer[n][n];
        return helper(nums, 0, n - 1, dp) >= 0;
    }

    // Returns the maximum score difference player 1 can achieve
    private static int helper(int[] nums, int i, int j, Integer[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] != null) return dp[i][j];
        // Player 1 picks nums[i] or nums[j]
        int pickLeft = nums[i] - helper(nums, i + 1, j, dp);
        int pickRight = nums[j] - helper(nums, i, j - 1, dp);
        dp[i][j] = Math.max(pickLeft, pickRight);
        return dp[i][j];
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 2};
        System.out.println(solve(nums)); // Output: false
        int[] nums2 = {1, 5, 233, 7};
        System.out.println(solve(nums2)); // Output: true
    }
}
