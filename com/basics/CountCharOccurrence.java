package com.basics;

public class CountCharOccurrence {

    public static void main(String[] args) {
        String word = "Hello World";
        char c = 'o';
        System.out.println("Count of '" + c + "' in \"" + word + "\": " + solve(word, c));
    }

    static int solve(String word, char c) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.toLowerCase().charAt(i) == c) {
                count++;
            }
        }
        return count;
    }
}
