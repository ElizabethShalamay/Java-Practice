package com.company.Condiments;

import com.company.Condiments.Exceptions.CondimentNotFoundException;

public abstract class Condiment {
    protected String name;
    protected double cost;

    public String getName() {
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

    public static Condiment createCondiment(String condimentName)
            throws CondimentNotFoundException{
            switch (condimentName){
                case "Milk":{
                    return  new Milk();
                }
                case "Whip":{
                    return  new Whip();
                }
                case "Sugar":{
                    return  new Sugar();
                }
                case "Cinnamon":{
                    return  new Cinnamon();
                }
                default:{
                    throw new CondimentNotFoundException();
                }
            }
    }
}
