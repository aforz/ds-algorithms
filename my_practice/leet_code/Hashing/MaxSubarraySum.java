package my_practice.leet_code.Hashing;

public class MaxSubarraySum {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long prefixSum = 0;
        long maxSum = Long.MIN_VALUE;
        long[] kSum = new long[k];
        for (int i = 0; i < k; i++) {
            kSum[i] = Long.MAX_VALUE / 2;
        }
        kSum[k - 1] = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            maxSum = Math.max(maxSum, prefixSum - kSum[i % k]);
            kSum[i % k] = Math.min(kSum[i % k], prefixSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaxSubarraySum solution = new MaxSubarraySum();
        int[] nums = {-1, -2, -3, -4, -5};
        int k = 4;
        long result = solution.maxSubarraySum(nums, k);
        System.out.println("The maximum subarray sum with the given condition is: " + result);
    }
}
