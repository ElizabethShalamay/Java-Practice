package com.company.Entities;

import com.company.Helpers.NumberGenerator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Account {
    private int _number;
    private String _clientName;
    private String _accountCode;
    private ArrayList<Payment> _payments;

    public Account(String clientName, String accountCode){
        _number = NumberGenerator.getNextAccountNumber();
        _clientName = clientName;
        _accountCode = accountCode;
        _payments = new ArrayList<Payment>();
    }

    public  void addPayment(Payment payment){
        _payments.add(payment);
    }

    public List<Payment> getPaymentsWithSpecificPurpose(String purpose){
        if(purpose == null && purpose.isEmpty())
            return new ArrayList<>();

        return _payments.stream()
                .filter(p -> p.getPurpose().equals(purpose))
                .collect(Collectors.toList());
    }

    public  List<Payment> getLargerPayments(double expectedAmount){
        if(expectedAmount < 0)
            return new ArrayList<>();

        return _payments.stream()
                .filter(payment -> payment.getAmount() > expectedAmount)
                .collect(Collectors.toList());
    }

    public  List<Payment> getPaymentsInDateRange(Date startDate, Date endDate){
        if(startDate == null && endDate == null && startDate.after(endDate))
            return new ArrayList<>();

        return _payments.stream()
                .filter(payment -> payment.getDate().after(startDate) && payment.getDate().before(endDate))
                .collect(Collectors.toList());
    }
}
