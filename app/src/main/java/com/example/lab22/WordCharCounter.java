package com.example.lab22;

public class WordCharCounter {

    // Method to count words in a given string
    public static int countWords(String text) {
        // Split the text by spaces, commas, or dots
        String[] words = text.split("[\\s,.]+");
        return words.length;
    }

    // Method to count characters in a given string (excluding spaces)
    public static int countCharacters(String text) {
        // Remove spaces and count remaining characters
        return text.replace(" ", "").length();
    }
}
