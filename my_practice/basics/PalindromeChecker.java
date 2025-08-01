package my_practice.basics;

public class PalindromeChecker {
    public static boolean isPalindrome(String s) {
        if (s == null) return false;

        int left = 0, right = s.length() - 1;
        while (left < right) {
            // Move left pointer to the next alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            // Move right pointer to the previous alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;

            // Compare characters (case-insensitive)
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Example usage
    public static void main(String[] args) {
        String input = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(input)); // Output: true
        String input2 = "race a car";
        System.out.println(isPalindrome(input2)); // Output: false
    }
}
