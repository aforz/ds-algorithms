package com.basics;

public class LeapYear {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Please enter the value: ");
        int num = sc.nextInt();
        if (num % 400 == 0) System.out.println("Leap Year");
        else if (num % 4 == 0 && num % 100 == 0) System.out.println("Not a Leap Year");
        else if (num % 4 == 0) System.out.println("Leap Year");
        else System.out.println("Not a Leap Year");
    }
}
