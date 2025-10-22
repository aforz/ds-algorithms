package my_practice.leet_code.Hashing;

import java.util.HashMap;

//Problem: https://leetcode.com/problems/subarray-sum-equals-k/description/
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // Default: empty prefix
        int count = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (prefixSumCount.containsKey(sum - k)) {
                count += prefixSumCount.get(sum - k);
            }
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK solver = new SubarraySumEqualsK();
        System.out.println(solver.subarraySum(new int[]{1, 1, 1}, 2)); // Output: 2
        System.out.println(solver.subarraySum(new int[]{1, 2, 3}, 3)); // Output: 2
    }
}
