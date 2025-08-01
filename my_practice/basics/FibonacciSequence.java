package my_practice.basics;

public class FibonacciSequence {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int num = sc.nextInt();
        System.out.println("Enter count to create Fibonacci sequence: " + num);
        int a = 0;
        int b = 1;
        System.out.print(a+ " ");
        System.out.print(b+ " ");
        for(int i = 3; i <= num; i++){
            int nextItem = a + b;
            System.out.print(nextItem + " ");
            a = b;
            b = nextItem;
        }
    }
}
