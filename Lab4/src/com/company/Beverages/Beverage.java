package com.company.Beverages;

import com.company.Beverages.Exceptions.BeverageNotFoundException;
import com.company.Condiments.Condiment;

import java.util.ArrayList;

public abstract class Beverage {
    protected String name;
    protected double cost;
    protected ArrayList<Condiment> condiments;

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }

    public ArrayList<Condiment> getCondiments() {
        return condiments;
    }

    public void addCondiment(Condiment condiment) {
        condiments.add(condiment);
    }

    public double countTotalCost(){
        double totalCost = cost;
        for (Condiment condiment: condiments) {
            totalCost += condiment.getCost();
        }
        return  totalCost;
    }

    public static Beverage createBeverage(String beverageName) throws BeverageNotFoundException{
         switch (beverageName){
             case "Americano":{
                 return new Americano();
             }
             case "Espresso":{
                 return  new Espresso();
             }
             case "Cappuccino":{
                 return  new Cappuccino();
             }
             case "Ice Coffee": {
                 return  new IceCoffee();
             }
             default:{
                 throw new BeverageNotFoundException();
             }
         }
    }
}

