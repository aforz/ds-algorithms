package my_practice.leet_code.String;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            // Skip non-alphanumeric characters from the left
            while (left < right && !isAlphaNumeric(s.charAt(left))) {
                left++;
            }
            // Skip non-alphanumeric characters from the right
            while (left < right && !isAlphaNumeric(s.charAt(right))) {
                right--;
            }
            // Compare characters (case-insensitive)
            if (toLower(s.charAt(left)) != toLower(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Helper method to check if a character is alphanumeric
    private boolean isAlphaNumeric(char c) {
        return (c >= 'A' && c <= 'Z') ||
                (c >= 'a' && c <= 'z') ||
                (c >= '0' && c <= '9');
    }

    // Helper method to convert uppercase character to lowercase
    private char toLower(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) (c + 32);
        }
        return c;
    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        System.out.println(vp.isPalindrome("A man, a plan, a canal: Panama")); // Output: true
        System.out.println(vp.isPalindrome("race a car")); // Output: false
        System.out.println(vp.isPalindrome(" ")); // Output: true
    }
}
