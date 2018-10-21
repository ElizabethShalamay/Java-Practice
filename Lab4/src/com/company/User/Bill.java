package com.company.User;

import com.company.Beverages.Beverage;
import com.company.Condiments.Condiment;
import java.util.ArrayList;

public class Bill {
    private double cost;
    private ArrayList<Beverage> beverages;

    public Bill() {
        beverages = new ArrayList<>();
    }

    public double getCost() {
        return cost;
    }

    public ArrayList<Beverage> getBeverages() {
        return beverages;
    }

    public void addBeverage(Beverage beverage) {
        beverages.add(beverage);
        cost += beverage.countTotalCost();
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();

        for(Beverage beverage: beverages){
            stringBuilder.append(beverage.getName()).append(", ");
            for (Condiment condiment: beverage.getCondiments()) {
                stringBuilder.append(condiment.getName()).append(", ");
            }
            stringBuilder.append(beverage.countTotalCost()).append("$ \n");
        }
        stringBuilder.append("Total cost: " + cost + "$");
        return  stringBuilder.toString();
    }
}
