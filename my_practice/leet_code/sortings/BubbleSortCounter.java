package my_practice.leet_code.sortings;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSortCounter {
    static SimpleEntry<List<Integer>, Integer> solve(int[] input) {
        int n = input.length;
        int[] arr = Arrays.copyOf(input, n); // Copy not to modify original
        int swapCount = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapCount++;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }

        // Convert int[] to List<Integer>
        List<Integer> sortedList = new ArrayList<>();
        for (int num : arr) sortedList.add(num);

        return new SimpleEntry<>(sortedList, swapCount);
    }

    // Example usage
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        var res = solve(arr);
        System.out.println("Sorted: " + res.getKey());
        System.out.println("Swaps: " + res.getValue());
    }
}
