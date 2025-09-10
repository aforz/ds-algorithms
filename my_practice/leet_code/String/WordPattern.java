package my_practice.leet_code.String;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        // Parse words manually without using split
        String[] words = new String[pattern.length() > 300 ? 3000 : 300];
        int wordCount = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            // Skip spaces
            while (i < n && s.charAt(i) == ' ') i++;
            if (i >= n) break;
            int start = i;
            while (i < n && s.charAt(i) != ' ') i++;
            int end = i; // exclusive
            words[wordCount++] = s.substring(start, end);
            i++;
        }
        if (wordCount != pattern.length()) return false;

        // Arrays to store mapping: pattern char -> word index, word index -> pattern char
        // Use arrays for performance due to small constraints
        String[] pat2word = new String[26];
        String[] word2pat = new String[wordCount];
        for (int j = 0; j < pattern.length(); j++) {
            char c = pattern.charAt(j);
            int pidx = c - 'a';
            String word = words[j];

            // Check pattern->word mapping
            if (pat2word[pidx] == null) {
                pat2word[pidx] = word;
            } else if (!pat2word[pidx].equals(word)) {
                return false;
            }

            // Check word->pattern mapping
            if (word2pat[j] == null) {
                // Look for this word in previous indices
                for (int k = 0; k < j; k++) {
                    if (words[k].equals(word)) {
                        if (pattern.charAt(k) != c) return false;
                    }
                }
                word2pat[j] = "" + c;
            } else if (!word2pat[j].equals("" + c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordPattern wp = new WordPattern();
        System.out.println(wp.wordPattern("abba", "dog cat cat dog"));
        System.out.println(wp.wordPattern("abba", "dog cat cat fish"));
    }
}
