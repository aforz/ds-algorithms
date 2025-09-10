package my_practice.leet_code.Array;

public class LongestZeroSumSubarray {
    // Simple manual hashmap for integer keys and values (open addressing)
    static class SimpleHashMap {
        int[] keys, values;
        boolean[] used;
        int size;

        public SimpleHashMap(int cap) {
            keys = new int[cap];
            values = new int[cap];
            used = new boolean[cap];
            size = cap;
        }

        int get(int key) {
            int idx = index(key);
            int start = idx;
            while (used[idx]) {
                if (keys[idx] == key) return values[idx];
                idx = (idx + 1) % size;
                if (idx == start) break;
            }
            return Integer.MIN_VALUE; // not found
        }

        void put(int key, int value) {
            int idx = index(key);
            while (used[idx]) {
                if (keys[idx] == key) return; // do not overwrite
                idx = (idx + 1) % size;
            }
            used[idx] = true;
            keys[idx] = key;
            values[idx] = value;
        }

        int index(int key) {
            return Math.abs(key) % size;
        }
    }

    public static int longestZeroSumSubarray(int[] arr) {
        int n = arr.length, maxLen = 0, sum = 0;
        SimpleHashMap map = new SimpleHashMap(2 * n + 1); // Capacity for open addressing
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == 0) maxLen = i + 1;
            int idx = map.get(sum);
            if (idx != Integer.MIN_VALUE) {
                maxLen = Math.max(maxLen, i - idx);
            } else {
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    // Example usage
    public static void main(String[] args) {
        System.out.println(longestZeroSumSubarray(new int[]{15, -2, 2, -8, 1, 7, 10, 23})); // Output: 5
        System.out.println(longestZeroSumSubarray(new int[]{1, 2, 3})); // Output: 0
    }
}
