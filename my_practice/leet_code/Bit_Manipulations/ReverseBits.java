package my_practice.leet_code.Bit_Manipulations;

public class ReverseBits {
    // n is a 32-bit unsigned integer (as int, since Java lacks unsigned types)
    static int solve(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;         // Shift result left to make room for next bit
            result |= (n & 1);    // Add the lowest bit of n to result
            n >>= 1;              // Shift n right to process next bit
        }
        return result;
    }

    // Helper for input as binary string
    static int solve(String bin32) {
        int n = (int) Long.parseLong(bin32, 2);
        return solve(n);
    }

    public static void main(String[] args) {
        String bin32 = "00000010100101000001111010011100";
        System.out.println(solve(bin32)); // Output: 964176192

    }
}
