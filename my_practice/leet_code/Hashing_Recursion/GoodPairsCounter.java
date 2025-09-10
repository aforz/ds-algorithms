package my_practice.leet_code.Hashing_Recursion;

public class GoodPairsCounter {
    public static int numIdenticalPairs(int[] nums) {
        int[] freq = new int[101]; // Since nums[i] ∈ [1,102]
        int count = 0;
        for (int num : nums) {
            count = count + freq[num];
            freq[num]++;
        }
        return count;
    }

    // Example usage
    public static void main(String[] args) {
        System.out.println(numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3})); // Output: 4
        System.out.println(numIdenticalPairs(new int[]{1, 1, 1, 1}));     // Output: 6
    }
}
