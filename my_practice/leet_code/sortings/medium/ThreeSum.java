package my_practice.leet_code.sortings.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // Step 1: Sort the array

        for (int i = 0; i < nums.length - 2; i++) {
            // Step 2: Skip duplicates for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];
                if (total == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // Step 3: Skip duplicates for left and right
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (total < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    // Example usage
    public static void main(String[] args) {
        ThreeSum solver = new ThreeSum();
        System.out.println(solver.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(solver.threeSum(new int[]{0, 1, 1}));
        System.out.println(solver.threeSum(new int[]{0, 0, 0}));
    }
}
