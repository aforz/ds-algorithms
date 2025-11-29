package my_practice.leet_code.Stack;

import java.util.ArrayList;
import java.util.Stack;

//Problem : https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1
public class NextLargerElement {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(n);
        Stack<Integer> stack = new Stack<>(); // Stack to store indices

        // Initialize result with -1s
        for(int i=0; i<n; i++) {
            result.add(-1);
        }

        for(int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                int idx = stack.pop();
                result.set(idx, arr[i]);
            }
            stack.push(i);
        }

        // Elements left in stack have no greater element; already set to -1

        return result;
    }

    public static void main(String[] args) {
        NextLargerElement solution = new NextLargerElement();
        int[] arr = {4, 5, 2, 10, 8};
        ArrayList<Integer> result = solution.nextLargerElement(arr);
        System.out.println("Next larger elements: " + result); // Output: [5, 10, 10, -1, -1]
    }
}
