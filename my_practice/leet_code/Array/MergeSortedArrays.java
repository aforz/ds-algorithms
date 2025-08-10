package my_practice.leet_code.Array;

public class MergeSortedArrays {
    /**
     * Merges nums2 into nums1 as one sorted array, in-place.
     * nums1 has a length of m + n, where the first m elements are valid,
     * and the last n elements are 0 (placeholders for nums2).
     * nums2 has a length of n.
     *
     * @param nums1 First sorted array, with extra space at the end for nums2.
     * @param m Number of valid elements in nums1.
     * @param nums2 Second sorted array.
     * @param n Number of valid elements in nums2.
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;       // Pointer for nums1
        int j = n - 1;       // Pointer for nums2
        int k = m + n - 1;   // Pointer for merged array (nums1)

        // Merge from the end to avoid overwriting nums1's elements
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        // If any elements remain in nums2, copy them
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
        // No need to copy remaining nums1 elements, as they're already in place
    }

    // Example usage
    public static void main(String[] args) {
        MergeSortedArrays merger = new MergeSortedArrays();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merger.merge(nums1, m, nums2, n);

        // Output: [1, 2, 2, 3, 5, 6]
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
}
