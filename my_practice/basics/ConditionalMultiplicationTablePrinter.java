package my_practice.basics;

public class ConditionalMultiplicationTablePrinter {
    static String[] solve(int n, int m) {
        java.util.List<String> list = new java.util.ArrayList<>();
        for (int i = 1; i <= m; i++) {
            if ((n * i) % 2 == 0 && (n * i) % 4 == 0) {
                String item = n + " x " + i + " = " + (n * i);
                list.add(item);
            }
        }
        if (list.isEmpty()) {
            return new String[]{"No qualifying multiples found."};
        }
        return list.toArray(new String[0]);
    }

    // main method
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Please enter n value: ");
        int n = sc.nextInt();
        System.out.print("Please enter m value: ");
        int m = sc.nextInt();
        String[] array = solve(n, m);
        for(String str: array) System.out.println(str);
    }
}
