package my_practice.leet_code.Hashing_Recursion;

public class ONE_TO_N {
    static int[] solve(int n) {
        int[] result = new int[n];
        fill(result, n);
        return result;
    }

    // Helper recursive function to fill the array
    private static void fill(int[] result, int n) {
        if (n == 0) return;
        fill(result, n - 1);
        result[n - 1] = n;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] result = solve(n);
        for (int num : result) {
            System.out.print(num + " "); // Output: 1 2 3 4 5
        }
    }
}
