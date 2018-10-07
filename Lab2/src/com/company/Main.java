package com.company;

import java.sql.Array;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        StringBuilder text = getTextFromConsole();
        Pattern pattern = Pattern.compile("\u0412|\u0432(\\w+)");

        String[] words = text.toString().split("\\s*(\\s|,|!|\\.)\\s*");

        int counter = 0;
        for (String word: words ) {
            Matcher matcher = pattern.matcher(word);

            if(matcher.find()){
                counter++;
            }
        }

        System.out.printf(String.valueOf(counter));
    }

    static StringBuilder getTextFromConsole(){
        Scanner scanner = new Scanner(System.in);
        Boolean fullyEntered = false;
        StringBuilder sb = new StringBuilder();

        System.out.printf("Enter some text:  ");

        while(!fullyEntered){
            String in = scanner.nextLine();
            if(in.equals(":q")){
                fullyEntered = true;
            }
            else {
                sb.append(in + "\n");
            }
        }
        return sb;
    }
}
