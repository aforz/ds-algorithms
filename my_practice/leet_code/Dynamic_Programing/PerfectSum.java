package my_practice.leet_code.Dynamic_Programing;

public class PerfectSum {
    public int perfectSum(int[] nums, int target) {
        // code here
        int[] dp = new int[target + 1];
        dp[0] = 1; // Empty subset always sums to zero

        for (int num : nums) {
            for (int t = target; t >= num; t--) {
                dp[t] += dp[t - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        PerfectSum ps = new PerfectSum();
        int[] nums = {2, 3, 5, 6, 8, 10};
        int target = 10;
        System.out.println("Number of subsets with sum " + target + ": " + ps.perfectSum(nums, target));
    }
}
