package my_practice.leet_code.searching;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left; // or right, since left == right
    }

    // For testing
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1, 1, 6, 2};
        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        FindPeakElement fpe = new FindPeakElement();
        System.out.println(fpe.findPeakElement(nums1)); // Output: 2
        System.out.println(fpe.findPeakElement(nums2)); // Output: 5
    }
}
