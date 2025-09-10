package my_practice.leet_code.Hashing_Recursion;

import java.util.HashMap;

public class UnequalTriplets {
    public int solve(int[] input) {
        int trips = 0;
        int pairs = 0;
        int n = input.length;
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int cnt = count.getOrDefault(input[i], 0);
            trips += pairs - cnt * (i - cnt);
            pairs += i - cnt;
            count.put(input[i], cnt + 1);
        }
        return trips;
    }

    public static void main(String[] args) {
        UnequalTriplets unequalTriplets = new UnequalTriplets();
        System.out.println(unequalTriplets.solve(new int[]{4, 4, 2, 4, 3})); // Output: 3
        System.out.println(unequalTriplets.solve(new int[]{1, 1, 1, 1, 1})); // Output: 0
        System.out.println(unequalTriplets.solve(new int[]{1, 2, 3}));       // Output: 1
    }
}
