package com.company;
import java.util.Random;

class Matrix {
    public int size;
    private byte[][] matrixArray;

    public Matrix (int size){
        this.size = size;
        matrixArray = new byte[size][size];
    }

    public void getArray(){
        Random random = new Random();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                matrixArray[i][j] = (byte)random.nextInt(100);
            }
        }
    }

    public void moveZerosToStart(){
        byte temp;
        int tempIndex = 0;
        for(int i = 0; i < matrixArray.length; i++){
            for(int j = 0; j < matrixArray[0].length; j++){
                if(matrixArray[i][j] == 0){
                    temp = matrixArray[i][tempIndex];
                    matrixArray[i][tempIndex] = 0;
                    matrixArray[i][j] = temp;
                    tempIndex += 1;
                }
            }
            tempIndex = 0;
        }
    }

    public void display(){
        for(int i = 0; i < matrixArray.length; i++){
            for(int j = 0; j < matrixArray[0].length; j++){
                System.out.printf("%5d", matrixArray[i][j]);
            }
            System.out.println();
        }
    }
}
