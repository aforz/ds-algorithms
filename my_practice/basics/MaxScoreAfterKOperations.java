package my_practice.basics;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxScoreAfterKOperations {
    /**
     * Maximizes the score by performing the described operation k times.
     * Each time, pick the largest number, add its value to score, remove it,
     * and add (m+1) back into the array.
     *
     * @param nums input array of integers
     * @param k    number of operations
     * @return maximum possible score
     */
    public int maximizeScore(int[] nums, int k) {
        // Use a max-heap to always select the largest element efficiently
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            maxHeap.offer(num);
        }

        int score = 0;
        for (int i = 0; i < k; i++) {
            int m = maxHeap.poll();
            score += m;
            maxHeap.offer(m + 1);
        }
        return score;
    }

    // Example usage
    public static void main(String[] args) {
        MaxScoreAfterKOperations msko = new MaxScoreAfterKOperations();
        int[] nums1 = {1, 2, 3, 4, 5};
        int k1 = 3;
        System.out.println(msko.maximizeScore(nums1, k1)); // Output: 18

        int[] nums2 = {5, 5, 5};
        int k2 = 2;
        System.out.println(msko.maximizeScore(nums2, k2)); // Output: 11
    }
}
