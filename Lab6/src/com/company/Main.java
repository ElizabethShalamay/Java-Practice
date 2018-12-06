package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        String path = s.nextLine(); // C:\Users\eliza\Documents

        System.out.print("Enter file name: ");
        String name = s.nextLine(); // text.txt

        File f = new File(path, name);

        List<String> data = readFromFile(f);
        writeToFile(f, data);
    }

    public static List<String> readFromFile(File f){
        if(!f.exists() || f.isDirectory()) {
            System.out.println("File with given path or name does not exist");
            System.exit(0);
        }

        List<String> lines = new ArrayList<String>();
        String line = null;

        System.out.println("Initial file content:");
        try{
            BufferedReader br = new BufferedReader(new FileReader(f));

            while ((line = br.readLine()) != null) {
                System.out.println(line);

                String[] words = line.split("\\s*(\\s|,|!|\\.)\\s*");
                String temp = words[words.length - 1];
                words[words.length - 1] = words[0];
                words[0] = temp;

                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < words.length; i++){
                    sb.append(words[i]).append(" ");
                }

                lines.add(sb.toString());
            }

            System.out.println("");
            br.close();
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        return lines;
    }

    public static void writeToFile(File f, List<String> data){
        if(!f.exists() || f.isDirectory()) {
            System.out.println("File with given path or name does not exist");
            System.exit(0);
        }

        System.out.println("Updated file content:");
        try{
            PrintWriter pw = new PrintWriter(new FileWriter(f));
            for (String line: data) {
                System.out.println(line);
                pw.println(line);
                pw.flush();
            }

            System.out.println();
            pw.close();
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
