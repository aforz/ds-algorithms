package my_practice.leet_code.maths;

public class MaximizeSumOfArrAfterKNegations {
    static int solve(int[] nums, int k) {
        java.util.Arrays.sort(nums); // Sort to bring the smallest (most negative) to front
        int i = 0;
        // Flip negatives first
        while (k > 0 && i < nums.length && nums[i] < 0) {
            nums[i] = -nums[i];
            i++;
            k--;
        }
        // If k still > 0 and k is odd, flip the smallest element
        int minIdx = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] < nums[minIdx]) minIdx = j;
        }
        if (k % 2 == 1) {
            nums[minIdx] = -nums[minIdx];
        }
        int sum = 0;
        for (int num : nums) sum += num;
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {3,-1,0,2};
        int k = 3;
        System.out.println(solve(nums, k)); // Output: 5
    }
}
