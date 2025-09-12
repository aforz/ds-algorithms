package my_practice.leet_code.maths;

public class EvenFactorSum {
    static int solve(int n){
        int sum = 0;
        for(int i = 2; i <= n; i += 2){
            if(n % i == 0){
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 30;
        int result = solve(n);
        System.out.println(result);
    }
}
