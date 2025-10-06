package my_practice.leet_code.recursion;

import java.util.Scanner;

//Multiplication of two numbers using Recursion
public class MultiplicationOfTwoNumbers {

    public static int mult(int x, int y) {
        if (x < y)
            return mult(y, x);
        else if (y != 0)
            return x + mult(x, y - 1);
        else
            return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println(mult(m, n));
    }
}
