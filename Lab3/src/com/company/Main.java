package com.company;

import com.company.Entities.Account;
import com.company.Entities.Bank;
import com.company.Entities.Payment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Payment payment1 = new Payment("For fun", 100, "PrivateBank",
                "1111 2222 3333 4444");

        Payment payment2 = new Payment("For future", 1000, "MonoBank",
                "1111 2222 3333 4444");

        Account account1 = new Account("Liza", "123456");
        Account account2 = new Account("Nadiia", "1232222");
        account1.addPayment(payment1);
        account2.addPayment(payment2);

        Bank bank1 = new Bank("PrivateBank", "000111222");
        bank1.addAccount(account1);
        bank1.addAccount(account2);

        ArrayList<Payment> paymentsByPurpose = (ArrayList<Payment>)
                bank1.getPaymentsWithSpecificPurpose("For fun");
        ArrayList<Payment> paymentsLargerThanAmount =( ArrayList<Payment>)
                bank1.getLargerPayments(250);

        SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");

        Date startDate = new Date();
        Date endDate = new Date();
        try{
            startDate = format.parse("2018-10-10");
            endDate = format.parse("2018-11-10");
        }
        catch (ParseException e) {
            System.out.println("Нераспаршена с помощью " + format);
        }

        ArrayList<Payment> paymentsInDateRange = (ArrayList<Payment>)
                bank1.getPaymentsInDateRange(startDate, endDate);

        System.out.println("Payments By Purpose");
        for (Payment payment: paymentsByPurpose) {
            System.out.println(payment);
        }

        System.out.println();

        System.out.println("Payments Larger Than 50");
        for (Payment payment: paymentsLargerThanAmount) {
            System.out.println(payment);
        }

        System.out.println();

        System.out.println("Payments In Date Range");
        for (Payment payment: paymentsInDateRange) {
            System.out.println(payment);
        }

        System.out.println();

    }
}
