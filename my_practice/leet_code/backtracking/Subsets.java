package my_practice.leet_code.backtracking;

import java.util.ArrayList;
import java.util.List;
// Problem: https://platform.bosscoderacademy.com/course/X0SLKWBDPUlLcC40nFe5/assignment/coding?problemId=permutations
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int start, List<Integer> tempList, List<List<Integer>> res) {
        res.add(new ArrayList<>(tempList)); // Add current subset
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);  // Include nums[i]
            backtrack(nums, i + 1, tempList, res); // Explore further
            tempList.remove(tempList.size() - 1);  // Backtrack (remove last)
        }
    }

    public static void main(String[] args) {
        Subsets s = new Subsets();
        int[] nums1 = {1, 2, 3};
        System.out.println(s.subsets(nums1));
    }
}
