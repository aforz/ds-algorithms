package my_practice.leet_code.Hashing_Recursion;

public class FrequencySortNoInbuilt {
    public static int[] frequencySort(int[] nums) {
        int n = nums.length;
        int min = -100, max = 100; // value range from constraints
        int range = max - min + 1;

        // Step 1: Build frequency array
        int[] freq = new int[range];
        for (int i = 0; i < n; i++) {
            freq[nums[i] - min]++;
        }

        // Step 2: Selection sort with custom comparator
        for (int i = 0; i < n - 1; i++) {
            int best = i;
            for (int j = i + 1; j < n; j++) {
                int fi = freq[nums[best] - min];
                int fj = freq[nums[j] - min];
                if (fj < fi || (fj == fi && nums[j] > nums[best])) {
                    best = j;
                }
            }
            // Swap
            int temp = nums[i];
            nums[i] = nums[best];
            nums[best] = temp;
        }
        return nums;
    }

    // Example usage
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2, 2, 2, 3};
        int[] result1 = frequencySort(nums1);
        for (int x : result1) System.out.print(x + " "); // Output: 3 1 1 2 2 2
        System.out.println();

        int[] nums2 = {2, 3, 1, 3, 2};
        int[] result2 = frequencySort(nums2);
        for (int x : result2) System.out.print(x + " "); // Output: 1 3 3 2 2
        System.out.println();
    }
}
