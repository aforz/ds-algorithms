package my_practice.leet_code.sortings;

public class AlternativeSorting {
    static int[] sort(int[]  input){
        int[] sortedArray = countSort(input);
        int[] result = new int[sortedArray.length];
        int left = 0, right = sortedArray.length-1, idx = 0;
        while(left < right){
            result[idx++] = sortedArray[right--];
            result[idx++] = sortedArray[left++];
        }
        if (left == right) result[idx] = sortedArray[left];
        return result;
    }

    static int[] countSort(int[] arr){
        int max = arr[0];
        int[] newArray = new int[arr.length];
        int idx = 0;
        for(int i = 0; i < arr.length; i++){
            if (arr[i] > max) max = arr[i];
        }
        int[] freq = new int[max+1];
        for(int i = 0; i < arr.length; i++){
            freq[arr[i]]++;
        }
        for (int i = 0; i <= max; i++){
            while (freq[i]-- > 0) newArray[idx++] = i;
        }
        return newArray;
    }

    public static void main(String[] args) {
        int[] input = {7, 1, 2, 3, 4, 5, 6};
        int[] result = sort(input);
        for(int num : result){
            System.out.print(num + " ");
        }
    }
}
