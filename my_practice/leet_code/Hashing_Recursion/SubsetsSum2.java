package my_practice.leet_code.Hashing_Recursion;

public class SubsetsSum2 {
    static int[] solve(int[] input){
        int N = input.length;
        int totalSubsets = 1 << N; // 2^N
        int[] result = new int[totalSubsets];
        for(int mask = 0; mask < totalSubsets; mask++){
            int sum = 0;
            for(int i = 0; i < N; i++){
                if((mask & (1 << i)) != 0){
                    sum += input[i];
                }
            }
            result[mask] = sum;
        }
        java.util.Arrays.sort(result);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3};
        int[] subsetSums = solve(arr);
        System.out.println(java.util.Arrays.toString(subsetSums)); // Output: [0, 2, 3, 5]
        int[] arr2 = {5, 2, 1};
        int[] subsetSums2 = solve(arr2);
        System.out.println(java.util.Arrays.toString(subsetSums2)); // Output: [0, 1, 2, 3, 5, 6, 7, 8]
    }
}
