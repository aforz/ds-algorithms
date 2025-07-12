package basics;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter value to check Palindrome: " + isPalindrome(sc.nextInt()));
    }

    public static boolean isPalindrome(int x) {
        int result = 0;
        int i = x;
        while (i > 0) {
            int rem = i % 10;
            result = result * 10 + rem;
            i = i / 10;
        }
        if (result == x) {
            return true;
        } else {
            return false;
        }
    }
}
