package my_practice.leet_code.Array;

public class ThirdMax {
    public static int thirdMax(int[] nums) {
        Long first = null, second = null, third = null;
        for (int num : nums) {
            long n = num;
            if (first != null && n == first) continue;
            if (second != null && n == second) continue;
            if (third != null && n == third) continue;

            if (first == null || n > first) {
                third = second;
                second = first;
                first = n;
            } else if (second == null || n > second) {
                third = second;
                second = n;
            } else if (third == null || n > third) {
                third = n;
            }
        }
        return third == null ? first.intValue() : third.intValue();
    }

    // Example usage
    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{3, 2, 1}));           // Output: 1
        System.out.println(thirdMax(new int[]{1, 2}));             // Output: 2
        System.out.println(thirdMax(new int[]{2, 2, 3, 1}));         // Output: 1
        System.out.println(thirdMax(new int[]{2, 2, 3, 1, 3, 2, 1, 1})); // Output: 1
        System.out.println(thirdMax(new int[]{1, 2, 2, 5, 3, 5}));     // Output: 2
    }
}
