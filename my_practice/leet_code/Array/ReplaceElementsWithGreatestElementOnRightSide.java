package my_practice.leet_code.Array;

public class ReplaceElementsWithGreatestElementOnRightSide {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int maxSoFar = -1; // for the last element result is -1

        for (int i = n - 1; i >= 0; i--) {
            int cur = arr[i];
            arr[i] = maxSoFar;
            if (cur > maxSoFar) maxSoFar = cur;
        }
        return arr;
    }

    public static void main(String[] args) {
        ReplaceElementsWithGreatestElementOnRightSide replacer = new ReplaceElementsWithGreatestElementOnRightSide();
        int[] arr = {17, 18, 5, 4, 6, 1};
        int[] result = replacer.replaceElements(arr);
        for (int num : result) {
            System.out.print(num + " "); // Output: 18 6 6 6 1 -1
        }
    }
}
