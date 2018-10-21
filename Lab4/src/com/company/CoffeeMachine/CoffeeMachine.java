package com.company.CoffeeMachine;

import com.company.Beverages.Beverage;
import com.company.Beverages.Exceptions.BeverageNotFoundException;
import com.company.Condiments.Condiment;
import com.company.Condiments.Exceptions.CondimentNotFoundException;

import java.util.ArrayList;

public class CoffeeMachine {
    private ArrayList<Beverage> beverages;
    private ArrayList<Condiment> condiments;

    public CoffeeMachine(){
        beverages = new ArrayList<>();
        condiments = new ArrayList<>();
    }

    void setBeverages(ArrayList<Beverage> beverages) {
        this.beverages = beverages;
    }

    void setCondiments(ArrayList<Condiment> condiments) {
        this.condiments = condiments;
    }

    public Beverage makeBeverage(String beverageName)throws BeverageNotFoundException{
        Beverage expectedBeverage;

        for(int i = 0; i < beverages.size(); i++){
            if(beverages.get(i).getName() == beverageName){
                expectedBeverage = Beverage.createBeverage(beverageName);
                beverages.remove(i);
                return expectedBeverage;
            }
        }

        throw new BeverageNotFoundException();
    }

    public Beverage makeBeverage(String beverageName, String[] condiments)
            throws BeverageNotFoundException, CondimentNotFoundException {
        Beverage expectedBeverage = makeBeverage(beverageName);

        Condiment expectedCondiment;
        for (String condiment:condiments) {
            for(int i = 0; i < this.condiments.size(); i++){
                if (this.condiments.get(i).getName() == condiment){
                    expectedCondiment = Condiment.createCondiment(condiment);
                    expectedBeverage.addCondiment(expectedCondiment);
                    this.condiments.remove(i);
                    break;
                }
            }
        }

        if(expectedBeverage.getCondiments().size() != condiments.length){
            throw new CondimentNotFoundException();
        }

        return expectedBeverage;
    }
}
