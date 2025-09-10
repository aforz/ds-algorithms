package my_practice.leet_code.maths;

public class Maximum69Number {
    public static int maximum69Number(int num) {
        int temp = num;
        int pos = 0;
        int firstSixPos = -1;
        int pow = 1;

        // Find the leftmost '6'
        while (temp > 0) {
            int digit = temp % 10;
            if (digit == 6) {
                firstSixPos = pos;
            }
            temp /= 10;
            pos++;
        }

        // If no '6' found, return the number itself
        if (firstSixPos == -1) return num;

        // Add 3 * 10^firstSixPos to change the leftmost '6' to '9'
        int add = 1;
        for (int i = 0; i < firstSixPos; i++) add *= 10;
        return num + 3 * add;
    }

    public static void main(String[] args) {
        int num = 9669;
        System.out.println(maximum69Number(num)); // Output: 9969
    }
}
