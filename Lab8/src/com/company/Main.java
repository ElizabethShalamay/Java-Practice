package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();

        numbers = fillListWithNumbers(numbers);
        System.out.print("Collection before search: ");
        displayNumbers(numbers);

        System.out.print("10 minimum values: ");
        findMins(numbers);

        System.out.print("Collection after search: ");
        displayNumbers(numbers);
    }

    private static void findMins(final List<Integer> numbers) {
        List<Integer> minimum = new ArrayList<Integer>();
        while (minimum.size() != 10){
            int minValue = Integer.MAX_VALUE;

            for (int j = 0; j < numbers.size(); j++) {
                if (numbers.get(j)< minValue && !minimum.contains(numbers.get(j))) {
                    minValue = numbers.get(j);
                }
            }

//            for(int number: numbers){
//                if(minValue == number){
                    minimum.add(minValue);
//                }
//            }
        }

        displayNumbers(minimum);
    }

    private static void displayNumbers(List<Integer> numbers) {
        for (int number: numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    private static List<Integer> fillListWithNumbers(List<Integer> numbers) {
        Scanner in = new Scanner(System.in);
        System.out.print("Would you like to fill collection manually ('Yes' or 'No')? ");
        String input = in.nextLine();

        if (input.equals("No")){
            return fillWithRandomNumbers(numbers);
        }

        System.out.println("Enter numbers with non-breaking space: ");

        String[] numberStrings = in.nextLine().split(" ");
        for (String numberString:numberStrings) {
            numbers.add(Integer.parseInt(numberString));
        }
        return numbers;
    }

    private static List<Integer> fillWithRandomNumbers(List<Integer> numbers) {
        Random random = new Random();

        for(int i = 0; i < 25; i++){
            numbers.add(random.nextInt(200));
        }
        return numbers;
    }
}
