package com.basics;

public class ArrayFiltering {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] result = sort(arr);
        for (int res : result) {
            System.out.print(res + " ");
        }
    }

    static int[] sort(int[] input) {
        java.util.List<Integer> list = new java.util.ArrayList<>();
        for (int i : input) {
            if (i % 2 == 0) {
                list.add(i);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
