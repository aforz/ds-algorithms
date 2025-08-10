package my_practice.leet_code.Array;
import java.util.*;

public class IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] frequencyArray1 = new int[1001];
        int[] frequencyArray2 = new int[1001];
        for (int num : nums1)
            frequencyArray1[num]++;
        for (int num : nums2)
            frequencyArray2[num]++;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1001; i++){
            int x = Math.min(frequencyArray1[i], frequencyArray2[i]);
            for (int j = 0; j < x; j++){
                list.add(i);
            }
        }
        return list.stream().mapToInt(Integer :: intValue).toArray();
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays2 obj = new IntersectionOfTwoArrays2();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = obj.intersect(nums1, nums2);
        System.out.println(Arrays.toString(result)); // Output: [2, 2]
    }
}

/*Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many
times as it shows in both arrays and you may return the result in any order.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.

Constraints:
1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000

Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?*/