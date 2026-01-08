package my_practice.leet_code.Array;

import java.util.Arrays;

public class CountCoveredBuildings {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int[] maxRow = new int[n + 1];
        int[] minRow = new int[n + 1];
        int[] maxCol = new int[n + 1];
        int[] minCol = new int[n + 1];

        Arrays.fill(minRow, n + 1);
        Arrays.fill(minCol, n + 1);

        for (int[] p : buildings) {
            int x = p[0];
            int y = p[1];
            maxRow[y] = Math.max(maxRow[y], x);
            minRow[y] = Math.min(minRow[y], x);
            maxCol[x] = Math.max(maxCol[x], y);
            minCol[x] = Math.min(minCol[x], y);
        }

        int res = 0;
        for (int[] p : buildings) {
            int x = p[0];
            int y = p[1];
            if (
                    x > minRow[y] && x < maxRow[y] && y > minCol[x] && y < maxCol[x]
            ) {
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        CountCoveredBuildings ccb = new CountCoveredBuildings();
        int n = 5;
        int[][] buildings = {
                {1, 3},
                {3, 2},
                {3, 3},
                {3, 5},
                {5, 3}
        };
        int result = ccb.countCoveredBuildings(n, buildings);
        System.out.println(result); // Output: 1
    }
}
