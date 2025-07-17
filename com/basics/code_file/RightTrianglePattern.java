package com.basics.code_file;

public class RightTrianglePattern {
    public static void main(String[] args) {
        int n = 5;
        java.util.List<String> result = solve(n);
        for (String row : result) {
            System.out.println(row);
        }
    }

    static java.util.List<String> solve(int n) {
        java.util.List<String> result = new java.util.ArrayList<>();
        for (int i = 1; i <= n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < i; j++) {
                row.append("*");
            }
            result.add(row.toString());
        }
        return result;
    }
}
