package my_practice.leet_code.backtracking;

import java.util.ArrayList;
import java.util.List;

// Problem: https://platform.bosscoderacademy.com/course/X0SLKWBDPUlLcC40nFe5/assignment/coding?problemId=permutations
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), new boolean[nums.length], results);
        return results;
    }

    private void backtrack(int[] nums, List<Integer> temp, boolean[] used, List<List<Integer>> results) {
        if (temp.size() == nums.length) {
            results.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            temp.add(nums[i]);
            backtrack(nums, temp, used, results);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }

    // For testing
    public static void main(String[] args) {
        Permutations p = new Permutations();
        int[] nums1 = {1, 2, 3};
        System.out.println(p.permute(nums1));
    }
}
