package com.company.CoffeeMachine;

import com.company.Beverages.*;
import com.company.Beverages.Exceptions.BeverageNotFoundException;
import com.company.Condiments.*;
import com.company.Condiments.Exceptions.CondimentNotFoundException;

import java.util.ArrayList;

public class CoffeeMachineAdministrator {
    private CoffeeMachine coffeeMachine;
    private static ArrayList<Beverage> standartBeverageSet;
    public static ArrayList<Condiment> standartCondimentSet;

    public CoffeeMachineAdministrator(CoffeeMachine machine){
        coffeeMachine = machine;
    }

    public CoffeeMachine getCoffeeMachine(){
        return coffeeMachine;
    }

    public void fillCoffeeMachine(){
        coffeeMachine.setBeverages(standartBeverageSet);
        coffeeMachine.setCondiments(standartCondimentSet);
    }

    static {
        try{
            standartBeverageSet = new ArrayList<>();
            for(int i = 0; i < 50; i++) {
                if (i < 15) {
                    standartBeverageSet.add(Beverage.createBeverage("Americano"));
                } else if (i < 30) {
                    standartBeverageSet.add(Beverage.createBeverage("Espresso"));
                } else if (i < 40) {
                    standartBeverageSet.add(Beverage.createBeverage("Cappuccino"));
                } else {
                    standartBeverageSet.add(Beverage.createBeverage("Ice Coffee"));
                }
            }
        }
        catch (BeverageNotFoundException ex){
        }

        standartCondimentSet = new ArrayList<>();
        try{
            for(int i = 0; i < 100; i++){
                if(i < 25){
                    standartCondimentSet.add(Condiment.createCondiment("Milk"));
                }
                else if(i < 50){
                    standartCondimentSet.add(Condiment.createCondiment("Whip"));
                }
                else if(i < 75){
                    standartCondimentSet.add(Condiment.createCondiment("Cinnamon"));
                }
                else{
                    standartCondimentSet.add(Condiment.createCondiment("Sugar"));
                }
            }
        }
        catch (CondimentNotFoundException ex){

        }
    }
}
