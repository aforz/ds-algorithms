package my_practice.leet_code.Hashing;

//Problem: https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1
public class LongestSubarrayWithSumK {
    /**
     * Returns the length of the longest subarray with sum equal to k.
     * Time: O(n), Space: O(n)
     */
    public static int longestSubarrayWithSumK(int[] arr, int k) {
        int n = arr.length;
        java.util.Map<Long, Integer> firstIndex = new java.util.HashMap<>();
        long prefix = 0L;
        int maxLen = 0;

        // prefix sum 0 occurs at index -1 to handle subarrays starting at 0
        firstIndex.put(0L, -1);

        long kLong = k; // use long to avoid overflow issues

        for (int i = 0; i < n; i++) {
            prefix += arr[i];

            // store earliest index for this prefix sum
            firstIndex.putIfAbsent(prefix, i);

            // want previousPrefix = prefix - k
            long need = prefix - kLong;
            if (firstIndex.containsKey(need)) {
                int len = i - firstIndex.get(need);
                if (len > maxLen) maxLen = len;
            }
        }
        return maxLen;
    }

    // quick tests using the examples from the prompt
    public static void main(String[] args) {
        int[] a1 = {10, 5, 2, 7, 1, -10};
        int k1 = 15;
        System.out.println(longestSubarrayWithSumK(a1, k1)); // expected 6

        int[] a2 = {-5, 8, -14, 2, 4, 12};
        int k2 = -5;
        System.out.println(longestSubarrayWithSumK(a2, k2)); // expected 5

        int[] a3 = {10, -10, 20, 30};
        int k3 = 5;
        System.out.println(longestSubarrayWithSumK(a3, k3)); // expected 0
    }
}
