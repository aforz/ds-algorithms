package my_practice.leet_code.Hashing;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        for (int right = 0;  right < s.length(); right++){
            char ch = s.charAt(right);
            if (map.containsKey(ch) && map.get(ch) >= left){
                left = map.get(ch) + 1;
            }
            map.put(ch, right);
            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters lswrc = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(lswrc.lengthOfLongestSubstring("abcabcbb")); // Output: 3
        System.out.println(lswrc.lengthOfLongestSubstring("bbbbb"));    // Output: 1
        System.out.println(lswrc.lengthOfLongestSubstring("pwwkew"));   // Output: 3
    }
}
