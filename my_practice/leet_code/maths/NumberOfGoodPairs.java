package my_practice.leet_code.maths;

public class NumberOfGoodPairs {
    static int count(int[] nums) {
        int count = 0;
        int[] freq = new int[101];
        for (int num : nums) {
            count += freq[num];
            freq[num]++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 1, 3};
//        int[] nums = {1, 1, 1, 1};
        System.out.println(count(nums));
    }
}
