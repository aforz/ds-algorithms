package my_practice.leet_code.maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPrimeFactors {
    static int[] solve(int n) {
        List<Integer> list = new ArrayList<>();
        while (n % 2 == 0) {
            list.add(2);
            n = n / 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i = i + 2) {
            while (n % i == 0) {
                list.add(i);
                n = n / i;
            }
        }
        if (n > 2) {
            list.add(n);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
//        int n = 315;
        int n = 100;
        int[] result = solve(n);
        System.out.println(Arrays.toString(result));
    }
}
