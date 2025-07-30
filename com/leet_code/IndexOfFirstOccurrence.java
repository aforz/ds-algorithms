package com.leet_code;

public class IndexOfFirstOccurrence {
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();
        if (nLen == 0) return 0; // Edge case: empty needle
        for (int i = 0; i <= hLen - nLen; i++) {
            if (haystack.substring(i, i + nLen).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        IndexOfFirstOccurrence solution = new IndexOfFirstOccurrence();
        String haystack = "sadbutsad";
        String needle = "sad";
        int result = solution.strStr(haystack, needle);
        System.out.println("The index of the first occurrence of '" + needle + "' in '" + haystack + "' is: " + result);
    }
}

/*Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
or -1 if needle is not part of haystack.

Example 1:
Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

Example 2:
Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.

Constraints:
1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.*/
