package my_practice.leet_code.String;

public class LicenseKeyFormatter {
    public String licenseKeyFormatting(String s, int k) {
        // Step 1: Count the number of alphanumeric chars
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '-') count++;
        }

        // Step 2: Prepare a char array for the result (worst case: need count + count/k dashes)
        char[] result = new char[count + count / k];
        int j = result.length - 1; // write position in result
        int group = 0;             // count within current group

        // Step 3: Iterate from the end of input, fill result from the end
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '-') continue;
            // Uppercase if it's a letter
            if (c >= 'a' && c <= 'z') c = (char) (c - 'a' + 'A');
            result[j--] = c;
            group++;
            // Add dash if needed and not at the start
            if (group == k && j >= 0 && count > k) {
                result[j--] = '-';
                group = 0;
            }
        }

        // Step 4: If there's a leading dash, skip it
        int start = 0;
        while (start < result.length && result[start] == '-') start++;

        // Step 5: Build final string
        return new String(result, start, result.length - start);
    }

    // Example usage:
    public static void main(String[] args) {
        LicenseKeyFormatter formatter = new LicenseKeyFormatter();
        System.out.println(formatter.licenseKeyFormatting("5F3Z-2e-9-w", 4)); // Output: "5F3Z-2E9W"
        System.out.println(formatter.licenseKeyFormatting("2-5g-3-J", 2));    // Output: "2-5G-3J"
    }
}
