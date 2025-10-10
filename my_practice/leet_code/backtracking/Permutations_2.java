package my_practice.leet_code.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Problem: https://platform.bosscoderacademy.com/course/X0SLKWBDPUlLcC40nFe5/assignment/coding?problemId=permutations
public class Permutations_2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // Sort to easily skip duplicates
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), used, res);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> tempList, boolean[] used, List<List<Integer>> res) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // Skip used or duplicate elements (only use the first occurrence at each level)
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;

            used[i] = true;
            tempList.add(nums[i]);
            backtrack(nums, tempList, used, res);
            tempList.remove(tempList.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Permutations_2 p = new Permutations_2();
        int[] nums1 = {1, 1, 2};
        System.out.println(p.permuteUnique(nums1));

        int[] nums2 = {1, 2, 3};
        System.out.println(p.permuteUnique(nums2));
    }
}
