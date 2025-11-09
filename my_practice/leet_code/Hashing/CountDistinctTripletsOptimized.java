package my_practice.leet_code.Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountDistinctTripletsOptimized {
    public int countDistinctTriplets(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);

        List<Integer> freqs = new ArrayList<>(freq.values());
        int n = nums.length;
        int result = 0;
        int prefix = 0;

        for (int f : freqs) {
            result += f * prefix * (n - prefix - f);
            prefix += f;
        }
        return result;
    }

    public static void main(String[] args) {
        CountDistinctTripletsOptimized solver = new CountDistinctTripletsOptimized();
        System.out.println(solver.countDistinctTriplets(new int[]{4,4,2,4,3}));      // Output: 3
        System.out.println(solver.countDistinctTriplets(new int[]{1, 1, 2, 2, 3, 3}));  // Output: 8
        System.out.println(solver.countDistinctTriplets(new int[]{1, 1, 1, 1}));      // Output: 0
    }
}
