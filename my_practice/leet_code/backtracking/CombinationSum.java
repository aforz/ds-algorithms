package my_practice.leet_code.backtracking;

import java.util.ArrayList;
import java.util.List;

// Problem: https://leetcode.com/problems/combination-sum/description/
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> combination, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(combination));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            combination.add(candidates[i]);
            // Not i + 1, because you can reuse same elements
            backtrack(candidates, target - candidates[i], i, combination, res);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum solver = new CombinationSum();
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        System.out.println("Combinations for target " + target1 + ": " + solver.combinationSum(candidates1, target1));

        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        System.out.println("Combinations for target " + target2 + ": " + solver.combinationSum(candidates2, target2));

        int[] candidates3 = {2};
        int target3 = 1;
        System.out.println("Combinations for target " + target3 + ": " + solver.combinationSum(candidates3, target3));
    }
}
