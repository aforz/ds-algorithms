package my_practice.basics;

public class PalindromeChecker1 {
    public static boolean isPalindrome(String s) {
        // Step 1: Normalize the string (remove non-alphanumerics, lowercase)
        StringBuilder normalized = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // Check if c is a letter or digit (without inbuilt Character.isLetterOrDigit)
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                // Convert to lowercase (without inbuilt toLowerCase)
                if (c >= 'A' && c <= 'Z') {
                    c = (char) (c + ('a' - 'A'));
                }
                normalized.append(c);
            }
        }
        // Step 2: Check palindrome
        int left = 0, right = normalized.length() - 1;
        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Simple main method to test
    public static void main(String[] args) {
        String input = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(input)); // Output: true
    }
}
