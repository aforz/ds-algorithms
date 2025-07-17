package com.basics;

public class PyramidPattern extends RightTrianglePattern {

    public void printPattern(int n) {
        for (int i = 1; i <= n; i++) {
            // Print leading spaces
            for (int j = i; j < n; j++) {
                System.out.print(" ");
            }
            // Print stars
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            // Move to the next line
            System.out.println();
        }
    }

    public static void main(String[] args) {
        PyramidPattern pyramid = new PyramidPattern();
        pyramid.printPattern(5);
    }
}
