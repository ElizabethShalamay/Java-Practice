package com.company.Entities;

import com.company.Helpers.NumberGenerator;
import java.util.Date;

public class Payment {
    private int _number;
    private String _purpose;
    private double _amount;
    private String _bankCode; // => Bank
    private String _settlementAccount; // => Account
    private Date _date;

    //constructor
    public Payment(String purpose, double amount, String bank, String account){
        _number = NumberGenerator.getNextPaymentNumber();
        _purpose = purpose;
        _amount = amount;
        _bankCode = bank;
        _settlementAccount = account;
        _date = new Date();
    }

    // methods (get,set)

    public  String getPurpose(){
        return _purpose;
    }

    public void setPurpose(String purpose){
        _purpose = purpose;
    }

    public double getAmount(){
        return _amount;
    }

    public String getBank(){
        return _bankCode;
    }

    public String getAccount(){
        return _settlementAccount;
    }

    public Date getDate(){
        return _date;
    }


    // toString() override


    @Override
    public String toString() {
        StringBuilder payment = new StringBuilder();

        payment.append("Payment N").append(_number)
                .append("\nPurpose: ").append(_purpose)
                .append("\nAmount: ").append(_amount)
                .append("\nBank: ").append(_bankCode)
                .append("\nAccount code: ").append(_settlementAccount)
                .append("\nDate: ").append(_date);

        return payment.toString();
    }
}
