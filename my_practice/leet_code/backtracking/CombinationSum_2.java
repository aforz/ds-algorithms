package my_practice.leet_code.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Problem: https://leetcode.com/problems/combination-sum-ii/
public class CombinationSum_2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // Sort to handle duplicates
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> tempList, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) break; // early stopping
            tempList.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, tempList, res);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum_2 solver = new CombinationSum_2();
        int[] candidates1 = {10, 1, 2, 7, 6, 1, 5};
        int target1 = 8;
        System.out.println("Combinations for target " + target1 + ": " + solver.combinationSum2(candidates1, target1));

        int[] candidates2 = {2, 5, 2, 1, 2};
        int target2 = 5;
        System.out.println("Combinations for target " + target2 + ": " + solver.combinationSum2(candidates2, target2));

        int[] candidates3 = {2, 3, 6, 7};
        int target3 = 7;
        System.out.println("Combinations for target " + target3 + ": " + solver.combinationSum2(candidates3, target3));
    }
}
