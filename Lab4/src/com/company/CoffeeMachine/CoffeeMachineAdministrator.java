package com.company.CoffeeMachine;

import com.company.Beverages.*;
import com.company.Condiments.*;

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
        standartBeverageSet = new ArrayList<>();
        for(int i = 0; i < 50; i++) {
            if (i < 15) {
                standartBeverageSet.add(new Americano());
            } else if (i < 30) {
                standartBeverageSet.add(new Espresso());
            } else if (i < 40) {
                standartBeverageSet.add(new Cappuccino());
            } else {
                standartBeverageSet.add(new IceCoffee());
            }
        }

        standartCondimentSet = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            if(i < 25){
                standartCondimentSet.add(new Milk());
            }
            else if(i < 50){
                standartCondimentSet.add(new Whip());
            }
            else if(i < 75){
                standartCondimentSet.add(new Cinnamon());
            }
            else{
                standartCondimentSet.add(new Sugar());
            }
        }
    }
}
