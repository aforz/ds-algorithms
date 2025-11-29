package my_practice.leet_code.Hashing;

public class MaxSumSubarrayDivByK {
    public long maxSumSubarrayDivByK(int[] nums, int k) {
        int n = nums.length;
        long[] minPref = new long[k];
        // initialize with +infinity
        for (int i = 0; i < k; i++) minPref[i] = Long.MAX_VALUE;
        // prefix sum at index 0 is 0 and 0 % k == 0
        minPref[0] = 0L;

        long pref = 0L;
        long ans = Long.MIN_VALUE;

        // r goes from 1..n (prefix index after taking nums[r-1])
        for (int r = 1; r <= n; r++) {
            pref += nums[r - 1];
            int rem = r % k;
            // if we have seen a prefix with same remainder, consider candidate
            if (minPref[rem] != Long.MAX_VALUE) {
                ans = Math.max(ans, pref - minPref[rem]);
            }
            // update minimal prefix sum for this remainder using current prefix
            if (pref < minPref[rem]) minPref[rem] = pref;
        }

        // It is guaranteed that at least one valid subarray exists by constraints,
        // but if not, ans may remain Long.MIN_VALUE. Return ans directly.
        return ans;
    }

    // quick demo using the problem examples
    public static void main(String[] args) {
        MaxSumSubarrayDivByK s = new MaxSumSubarrayDivByK();

        int[] a1 = {1,2};
        System.out.println(s.maxSumSubarrayDivByK(a1, 1)); // 3

        int[] a2 = {-1,-2,-3,-4,-5};
        System.out.println(s.maxSumSubarrayDivByK(a2, 4)); // -10

        int[] a3 = {-5,1,2,-3,4};
        System.out.println(s.maxSumSubarrayDivByK(a3, 2)); // 4
    }
}
