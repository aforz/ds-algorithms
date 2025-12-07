package my_practice.leet_code.heap;

import java.util.HashSet;
import java.util.PriorityQueue;

public class ThirdMax {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            // only consider distinct values
            if (seen.add(num)) {
                heap.add(num);
                if (heap.size() > 3) {
                    int removed = heap.poll();
                    seen.remove(removed);
                }
            }
        }
        // If we have at least three distinct numbers, the min-heap's root is the 3rd maximum
        if (heap.size() == 3) return heap.peek();
        // Otherwise return the maximum among the distinct numbers we have
        int max = Integer.MIN_VALUE;
        for (int x : heap) {
            if (x > max) max = x;
        }
        return max;
    }

    public static void main(String[] args) {
        ThirdMax tm = new ThirdMax();
        int[] nums = {2, 2, 3, 1};
        int result = tm.thirdMax(nums);
        System.out.println("The third maximum number is: " + result);
    }
}
