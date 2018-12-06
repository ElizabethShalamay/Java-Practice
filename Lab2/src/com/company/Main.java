package com.company;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter text: ");

        Scanner scanner = new Scanner(System.in);

        String inputText = scanner.nextLine();
        Pattern pattern = Pattern.compile("(B|b)(\\w+)");

        int countMatch = countRegexMachings(pattern, inputText);

        System.out.println("Pattern: " + pattern.toString());
        System.out.println("Count of matchings: " + countMatch);
    }

    public static int countRegexMachings(Pattern pattern, String text) {
        String[] words = text.split("\\s*(\\s|,|!|\\.)\\s*");

        int counter = 0;
        for (String word : words) {
            System.out.println(word);
            if (pattern.matcher(word).find()) {
                counter++;
            }
        }
        return counter;
    }
}
