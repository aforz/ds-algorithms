package my_practice.leet_code.Hashing_Recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FrequencySort {
    public static int[] frequencySort(int[] nums) {
        // Count frequencies
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);

        // Sort with custom comparator
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, (a, b) -> {
            int fa = freq.get(a), fb = freq.get(b);
            if (fa != fb) return fa - fb;         // Frequency ascending
            else return b - a;                    // Value descending
        });

        // Convert back to int[]
        return Arrays.stream(arr).mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(frequencySort(new int[]{1, 1, 2, 2, 2, 3}))); // [3, 1, 1, 2, 2, 2]
        System.out.println(Arrays.toString(frequencySort(new int[]{2, 3, 1, 3, 2})));   // [1, 3, 3, 2, 2]
    }
}

/*Given an array of integers nums, sort the array in increasing order based on the frequency of the values.
If multiple values have the same frequency, sort them in decreasing order.
Return the sorted array.

Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.

Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]

Constraints:
1 <= nums.length <= 100
-100 <= nums[i] <= 100*/