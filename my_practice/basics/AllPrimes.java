package my_practice.basics;

public class AllPrimes {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int L = sc.nextInt();
        int R = sc.nextInt();
        for(int i = L; i <= R; i++){
            if(isPrime(i)){
                System.out.print(i+ " ");
            }
        }
    }

    public static boolean isPrime(int n){
        if (n < 2) return false;
        for (int i = 2; i*i <= n; i++){
            if(n%i == 0) return false;
        }
        return true;
    }
}
