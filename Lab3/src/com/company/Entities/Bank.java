package com.company.Entities;

import com.company.Helpers.NumberGenerator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bank {
    private  int _number;
    private String _name;
    private String _bankCode;
    private List<Account> _accounts;

    public Bank(String name, String bankCode){
        _number = NumberGenerator.getNextAccountNumber();
        _name = name;
        _bankCode = bankCode;
        _accounts = new ArrayList<Account>();
    }

    public  void addAccount(Account account){
        _accounts.add(account);
    }

    public List<Payment> getPaymentsWithSpecificPurpose(String purpose){
        if(purpose == null && purpose.isEmpty())
            return new ArrayList<>();

        ArrayList<Payment> payments = new ArrayList<>();

        for (Account account: _accounts) {
            payments.addAll(account.getPaymentsWithSpecificPurpose(purpose));
        }
        return  payments;
    }

    public  List<Payment> getLargerPayments(double expectedAmount){
        if(expectedAmount < 0)
            return new ArrayList<>();

        ArrayList<Payment> payments = new ArrayList<>();

        for (Account account: _accounts) {
            payments.addAll(account.getLargerPayments(expectedAmount));
        }
        return  payments;
    }

    public  List<Payment> getPaymentsInDateRange(Date startDate, Date endDate){
        if(startDate == null && endDate == null && startDate.after(endDate))
            return new ArrayList<>();

        ArrayList<Payment> payments = new ArrayList<>();

        for (Account account: _accounts) {
            payments.addAll(account.getPaymentsInDateRange(startDate, endDate));
        }
        return  payments;
    }
}
