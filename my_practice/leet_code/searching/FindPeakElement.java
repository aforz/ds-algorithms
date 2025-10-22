package my_practice.leet_code.searching;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                // Peak is on the right side
                left = mid + 1;
            } else {
                // Peak is on the left side (including mid)
                right = mid;
            }
        }
        // left == right is the index of a peak element
        return left;
    }

    public static void main(String[] args) {
        FindPeakElement finder = new FindPeakElement();
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Peak index: " + finder.findPeakElement(nums1)); // Output: 2

        int[] nums2 = {1, 2, 7, 3, 5, 6, 4};
        System.out.println("Peak index: " + finder.findPeakElement(nums2)); // Output: 5 (or 1, both are peaks)
    }
}
