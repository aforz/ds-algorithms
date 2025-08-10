package my_practice.codechef;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IntersectingArrays {
    public static List<Integer> intersect(int[] nums1, int[] nums2) {
        int[] v = new int[101];
        int[] c = new int[101];
        for (int num : nums1) {
            v[num]++;
        }
        for (int num : nums2) {
            c[num]++;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            int x = Math.min(v[i], c[i]);
            for (int j = 0; j < x; j++) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nums1Size = scanner.nextInt();
        int nums2Size = scanner.nextInt();
        int[] nums1 = new int[nums1Size];
        int[] nums2 = new int[nums2Size];
        for (int i = 0; i < nums1Size; i++) {
            nums1[i] = scanner.nextInt();
        }
        for (int i = 0; i < nums2Size; i++) {
            nums2[i] = scanner.nextInt();
        }
        List<Integer> ans = intersect(nums1, nums2);
        for (int num : ans) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
