package com.company.User;

import com.company.Beverages.Beverage;
import com.company.Beverages.Exceptions.*;
import com.company.CoffeeMachine.CoffeeMachine;
import com.company.Condiments.Exceptions.CondimentNotFoundException;


public class User {
    private String name;
    private Bill bill;

    public User(String name){
        this.name = name;
        this.bill = new Bill();
    }

    public void buySingleBeverage (CoffeeMachine coffeeMachine, String beverage, String[] condiments)
            throws BeverageNotFoundException, CondimentNotFoundException {
                Beverage coffee = coffeeMachine.makeBeverage(beverage, condiments);
                bill.addBeverage(coffee);
    }

    public void buyMultipleBeverages(Beverage[] beverages){
        for(Beverage beverage : beverages){
            bill.addBeverage(beverage);
        }
    }

    public void payBill(){
        System.out.println(bill);
        System.out.println("Enjoy your beverages, " + name + " :)");
    }
}
