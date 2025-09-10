package my_practice.leet_code.Bit_Manipulations;

public class AddBinary {
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int bitA = (i >= 0) ? a.charAt(i) - '0' : 0;
            int bitB = (j >= 0) ? b.charAt(j) - '0' : 0;
            int sum = bitA + bitB + carry;
            sb.append(sum % 2);
            carry = sum / 2;
            i--;
            j--;
        }
        sb.reverse();
        return sb.toString();
    }

    // Example usage
    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));      // Output: "100"
        System.out.println(addBinary("1010", "1011")); // Output: "10101"
    }
}
