package my_practice.leet_code.Bit_Manipulations;

public class AddBinaryBitManipulation {
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = (i >= 0) ? a.charAt(i--) - '0' : 0;
            int y = (j >= 0) ? b.charAt(j--) - '0' : 0;

            int sum = x ^ y ^ carry; // XOR for sum bit
            carry = ((x & y) | (x & carry) | (y & carry)); // carry calculation
            sb.append(sum);
        }
        // If carry is left, append it
        // NOTE: Since the above loop handles carry, no need to append again
        return sb.reverse().toString();
    }

    // Example usage
    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));      // Output: "100"
        System.out.println(addBinary("1010", "1011")); // Output: "10101"
    }
}
