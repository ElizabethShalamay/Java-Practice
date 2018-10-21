package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.printf("Enter matrix size:  ");
        int size = in.nextInt();

        Matrix matrix = new Matrix(size);

	    matrix.fillArrayWithRandomNumbers();
        matrix.display();

        System.out.println();

        matrix.moveZerosToStart();
        matrix.display();
    }
}
