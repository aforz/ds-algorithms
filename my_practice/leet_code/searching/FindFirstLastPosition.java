package my_practice.leet_code.searching;

public class FindFirstLastPosition {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        result[0] = findBound(nums, target, true);  // First occurrence
        result[1] = findBound(nums, target, false); // Last occurrence
        return result;
    }

    // Helper function to find first or last occurrence using binary search
    private static int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1, bound = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                bound = mid; // Found a target, record it
                if (isFirst) {
                    right = mid - 1; // Look for earlier occurrence
                } else {
                    left = mid + 1; // Look for later occurrence
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else { // nums[mid] > target
                right = mid - 1;
            }
        }
        return bound;
    }

    // Example usage
    public static void main(String[] args) {
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        int[] res1 = searchRange(nums1, target1);
        System.out.println("[" + res1[0] + "," + res1[1] + "]"); // [3,4]

        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        int[] res2 = searchRange(nums2, target2);
        System.out.println("[" + res2[0] + "," + res2[1] + "]"); // [-1,-1]

        int[] nums3 = {};
        int target3 = 0;
        int[] res3 = searchRange(nums3, target3);
        System.out.println("[" + res3[0] + "," + res3[1] + "]"); // [-1,-1]
    }
}
