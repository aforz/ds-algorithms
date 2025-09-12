package my_practice.leet_code.Hashing_Recursion;
import java.util.*;

public class SubsetsSum {
    static List<Integer> solve(int[] arr) {
        List<Integer> result = new ArrayList<>();
        subsetSums(arr, 0, 0, result);
        Collections.sort(result);
        return result;
    }

    // Helper recursive method to generate subset sums
    private static void subsetSums(int[] arr, int idx, int sum, List<Integer> result) {
        if (idx == arr.length) {
            result.add(sum);
            return;
        }
        // Exclude current element
        subsetSums(arr, idx + 1, sum, result);
        // Include current element
        subsetSums(arr, idx + 1, sum + arr[idx], result);
    }

    public static void main(String[] args) {
        int[] arr = {2, 3};
        List<Integer> subsetSums = solve(arr);
        System.out.println(subsetSums); // Output: [0, 1, 2, 3, 3, 4, 5, 6]
        int[] arr2 = {5, 2, 1};
        List<Integer> subsetSums2 = solve(arr2);
        System.out.println(subsetSums2); // Output: [0, 1, 2, 3, 5, 6, 7, 8]
    }
}
