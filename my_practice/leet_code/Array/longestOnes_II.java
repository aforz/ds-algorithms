package my_practice.leet_code.Array;

public class longestOnes_II {
    public int longestOnes(int[] nums) {
        int left = 0;
        int zeros = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeros++;

            while (zeros > 1) {
                if (nums[left] == 0) zeros--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        longestOnes_II solution = new longestOnes_II();
        int[] nums = {1, 0, 1, 1, 0};
        int result = solution.longestOnes(nums);
        System.out.println("The longest subarray of 1s after flipping at most one 0 is: " + result);
    }
}
