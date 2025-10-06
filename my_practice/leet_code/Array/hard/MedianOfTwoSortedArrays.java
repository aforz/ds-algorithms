package my_practice.leet_code.Array.hard;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length, n = nums2.length;
        int left = 0, right = m;
        while (left <= right) {
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;

            int nums1Left = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1Right = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int nums2Left = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2Right = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
                if ((m + n) % 2 == 0) {
                    return ((Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2.0);
                } else {
                    return (double) Math.max(nums1Left, nums2Left);
                }
            } else if (nums1Left > nums2Right) {
                right = i - 1; // move left
            } else {
                left = i + 1; // move right
            }
        }
        throw new IllegalArgumentException("Input arrays are not sorted or empty.");
    }

    // Example usage
    public static void main(String[] args) {
        MedianOfTwoSortedArrays solver = new MedianOfTwoSortedArrays();
        System.out.println(solver.findMedianSortedArrays(new int[]{1, 3}, new int[]{2})); // Output: 2.0
        System.out.println(solver.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4})); // Output: 2.5
    }
}
