package my_practice.leet_code.Bit_Manipulations;

public class SumXorAllSubsets {
    static int solve(int[] arr) {
        int n = arr.length;
        int totalSubsets = 1 << n;
        int sum = 0;
        for (int mask = 0; mask < totalSubsets; mask++) {
            int xor = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    xor ^= arr[i];
                }
            }
            sum += xor;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,6};
        System.out.println(solve(arr)); // Output: 28
        int[] arr2 = {1,2};
        System.out.println(solve(arr2)); // Output: 6
    }
}
