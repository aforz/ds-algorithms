package my_practice.leet_code.Hashing_Recursion;

public class N_TO_ONE {
    static int[] solve(int n){
        int[] result = new int[n];
        fill(result, n);
        return result;
    }

    // Helper recursive function to fill the array from N to 1
    private static void fill(int[] result, int n) {
        if (n == 0) return;
        result[result.length - n] = n;
        fill(result, n - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        int[] result = solve(n);
        for (int num : result) {
            System.out.print(num + " "); // Output: 5 4 3 2 1
        }
    }
}
