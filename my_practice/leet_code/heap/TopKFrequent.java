package my_practice.leet_code.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) return nums;
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        Queue<Integer> heap = new PriorityQueue<>(
                (n1, n2) -> counts.get(n1) - counts.get(n2)
        );
        for (int num : counts.keySet()) {
            heap.add(num);
            if (heap.size() > k) heap.remove();
        }
        int[] top = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            top[i] = heap.poll();
        }
        return top;
    }

    public static void main(String[] args) {
        TopKFrequent tkf = new TopKFrequent();
        int[] nums = {1, 1, 1, 2, 2, 3, 4,4,4,4};
        int k = 2;
        int[] result = tkf.topKFrequent(nums, k);
        System.out.print("The top " + k + " frequent elements are: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
