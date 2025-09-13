package my_practice.leet_code.maths;

public class LargestPerimeterTriangle {
    static int solve(int[] nums) {
        java.util.Arrays.sort(nums);
        int n = nums.length;
        // Check from the largest side downwards
        for (int i = n - 1; i >= 2; i--) {
            int a = nums[i - 2], b = nums[i - 1], c = nums[i];
            // Triangle condition: sum of two smallest sides > largest side
            if (a + b > c) {
                return a + b + c;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 2};
        System.out.println(solve(nums)); // Output: 5
    }
}
