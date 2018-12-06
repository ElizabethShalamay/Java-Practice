package Entities;

import Exceptions.NegativeAmountException;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Account {
    private static int index = 0;
    private Payment[] payments;

    public Account(int size){
        if(size > 0)
            payments = new Payment[size];
        else{
            System.out.println("Cannot create account with negative size. Size will be converted into positive."
                    + "\nAccount size is "+ -size);
            payments = new Payment[-size];
        }
    }

    public Payment[] getPayments(){
        return  payments;
    }

    public  void addPayment(Payment payment){
        if(index < payments.length){
            payments[index] = payment;
            index++;
        }
        else{
            System.out.println("Array is full. Cannot add more payments");
        }
    }

    public Payment[] getPaymentsWithSpecificPurpose(String purpose){
        if(purpose == null && purpose.isEmpty())
            return new Payment[0];

        List<Payment> list = Arrays.stream(payments)
                .filter(payment -> payment != null && payment.getPurpose().equals(purpose))
                .collect(Collectors.toList());

        Payment[] selectedPayments = new Payment[list.size()];
        list.toArray(selectedPayments);
        return  selectedPayments;
    }

    public  Payment[] getLargerPayments (double expectedAmount)throws NegativeAmountException{
        if(expectedAmount < 0)
            throw new NegativeAmountException();

        List<Payment> list = Arrays.stream(payments)
                .filter(payment -> payment != null && payment.getAmount() >= expectedAmount)
                .collect(Collectors.toList());

        Payment[] selectedPayments = new Payment[list.size()];
        list.toArray(selectedPayments);
        return  selectedPayments;
    }

    public  Payment[] getPaymentsInDateRange(Date startDate, Date endDate){
        if(startDate == null && endDate == null && startDate.after(endDate))
            return new Payment[0];

        List<Payment> list = Arrays.stream(payments)
                .filter(payment -> payment != null && payment.getDate().after(startDate)
                        && payment.getDate().before(endDate))
                .collect(Collectors.toList());

        Payment[] selectedPayments = new Payment[list.size()];
        list.toArray(selectedPayments);
        return  selectedPayments;
    }

    public static void displaySelectedPayments(Payment[] payments){
        if(payments.length == 0){
            System.out.println("No payments found");
        }
        else{
            for (Payment payment: payments) {
                if(payment == null)
                    continue;
                System.out.println(payment);
            }
        }

        System.out.println();
    }
}
