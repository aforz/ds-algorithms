package my_practice.leet_code.recursion;

public class IsPalindrome {
    static boolean isPalindrome(String s) {
        return helper(s, 0, s.length() - 1);
    }

    static boolean helper(String s, int left, int right) {
        if (left >= right) return true;
        if (s.charAt(left) != s.charAt(right)) return false;
        return helper(s, left + 1, right - 1);
    }

    public static void main(String[] args) {
        String s = "racecar";
        System.out.println(isPalindrome(s));
    }
}
