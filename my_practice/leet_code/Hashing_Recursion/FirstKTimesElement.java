package my_practice.leet_code.Hashing_Recursion;

public class FirstKTimesElement {
    public static int firstElementKTimes(int[] arr, int K) {
//        int[] freq = new int[1001]; // since 1 <= A[i] <= 1000
//        for (int num : arr) {
//            freq[num]++;
//            if (freq[num] == K) return num;
//        }

        // 2nd method using hashmap
        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) == K) return num;
        }
        return -1;
    }

    // Example usage
    public static void main(String[] args) {
        int[] arr1 = {1, 7, 4, 3, 4, 8, 7};
        int N1 = 7, K1 = 2;
        System.out.println(firstElementKTimes(arr1, K1)); // Output: 4

        int[] arr2 = {1, 7, 4, 3, 4, 8, 7};
        int N2 = 7, K2 = 1;
        System.out.println(firstElementKTimes(arr2, K2)); // Output: 1

        int[] arr3 = {1, 2, 3, 4, 5};
        int N3 = 5, K3 = 2;
        System.out.println(firstElementKTimes(arr3, K3)); // Output: -1
    }
}
