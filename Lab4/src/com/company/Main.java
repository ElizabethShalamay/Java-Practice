package com.company;

import com.company.Beverages.Exceptions.BeverageNotFoundException;
import com.company.CoffeeMachine.*;
import com.company.Condiments.Exceptions.CondimentNotFoundException;
import com.company.User.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        User user = initializeUser();

        CoffeeMachine coffeeMachine = new CoffeeMachine();
        CoffeeMachineAdministrator administrator = new CoffeeMachineAdministrator(coffeeMachine);

        administrator.fillCoffeeMachine();
        startCoffeeMachine(user, administrator);
    }

    private static User initializeUser(){
        Scanner in = new Scanner(System.in);
        System.out.println("Hello! What is your name?");
        String name = in.nextLine();

        return  new User(name);
    }

    private  static void startCoffeeMachine(User user, CoffeeMachineAdministrator administrator){
        boolean userWantsMoreCoffee = true;
        while (userWantsMoreCoffee){
            String beverage = chooseBeverage();
            String[] condiments = chooseCondiments();

            try {
                user.buySingleBeverage(administrator.getCoffeeMachine(), beverage, condiments);
            }
            catch (BeverageNotFoundException ex){
                askForCallingAdministrator(administrator);
            }
            catch (CondimentNotFoundException ex){
                askForCallingAdministrator(administrator);
            }

            userWantsMoreCoffee = askForOneMoreDrink(user);
        }
    }

    private static String[] chooseCondiments(){
        Scanner in = new Scanner(System.in);
        ArrayList<String> condiments = new ArrayList<>();
        while(true){
            System.out.println("Choose condiments: \n1. Milk \n2. Whip \n3.Sugar \n4.Cinnamon \n0. Enough");
            try {
                int condimentNumber = Integer.parseInt(in.nextLine());

                if(condimentNumber == 0)
                     break;
                condiments.add(Main.condiments[condimentNumber -1]);
            }
            catch (NumberFormatException ex){
                System.out.println("Wrong format. Please try again");
            }
        }
        return condiments.toArray(new String[condiments.size()]);
    }
    private static String chooseBeverage(){
            Scanner in = new Scanner(System.in);
            System.out.println("Choose beverage: \n1. Espresso \n2. Americano \n3. Cappuccino \n4. IceCoffee");
            int beverageNumber = Integer.parseInt(in.nextLine());
            return beverages[beverageNumber - 1];
    }
    private static boolean askForOneMoreDrink(User user) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("One more drink? ('Yes' or 'No')?");
            String answer = in.nextLine();

            if (answer.equals("Yes")) {
                return true;
            }
            else if (answer.equals("No")) {
                user.payBill();
                return false;
            }
            else {
                System.out.println("Wrong format answer. Please try again");
            }
        }
    }

    private static final String[] beverages = {"Espresso", "Americano", "Cappuccino", "Ice Coffee"};
    private static final String[] condiments = {"Milk", "Whip", "Sugar", "Cinnamon"};

    private static void askForCallingAdministrator(CoffeeMachineAdministrator administrator){
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Coffee machine cannot make this beverage. " +
                    "\nWould you like administrator to fill the machine? ('Yes' or 'No')?");
            String answer = in.nextLine();
            if(answer.equals("Yes")){
                administrator.fillCoffeeMachine();
            }
            else if(answer.equals("No")){
                System.out.println("Choose another drink");
            }
            else{
                System.out.println("Wrong format answer. Please try again");
            }
        }
    }
}

