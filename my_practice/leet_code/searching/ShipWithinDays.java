package my_practice.leet_code.searching;

// Problem: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
public class ShipWithinDays {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for (int w : weights) {
            left = Math.max(left, w); // find the heaviest package
            right += w; // sum up all weights
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canShip(weights, days, mid)) {
                right = mid; // try smaller capacity
            } else {
                left = mid + 1; // need bigger capacity
            }
        }
        return left;
    }

    // Helper function to check if it's possible to ship with given capacity in days
    private boolean canShip(int[] weights, int days, int capacity) {
        int cur = 0, nDays = 1;
        for (int w : weights) {
            if (cur + w > capacity) {
                nDays++;    // start a new day
                cur = 0;
            }
            cur += w;      // load package
        }
        return nDays <= days; // true if we can do it in the given days
    }

    public static void main(String[] args) {
        ShipWithinDays solver = new ShipWithinDays();
        System.out.println(solver.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5)); // Output: 15
        System.out.println(solver.shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3)); // Output: 6
        System.out.println(solver.shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4)); // Output: 3
    }
}
