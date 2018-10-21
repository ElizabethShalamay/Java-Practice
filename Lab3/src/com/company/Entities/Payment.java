package com.company.Entities;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Payment {
    private static int NUMBER;
    private int number;
    private String purpose;
    private double amount;
    private String bankCode;
    private String settlementAccount;
    private Date date;

    //constructor
    public Payment() {
        number = NUMBER++;
    }
    public Payment(String purpose, double amount, String bank, String account){
        number = NUMBER++;
        this.purpose = purpose;
        this.amount = amount;
        bankCode = bank;
        settlementAccount = account;
        date = new Date();
    }
    public Payment(String purpose, double amount, String bank, String account, Date date){
        number = NUMBER++;
        this.purpose = purpose;
        this.amount = amount;
        bankCode = bank;
        settlementAccount = account;
        this.date = date;
    }

    // methods (get,set)

    public  String getPurpose(){
        return purpose;
    }
    public void setPurpose(String purpose){

        this.purpose = purpose;
    }

    public double getAmount(){
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSettlementAccount(){

        return settlementAccount;
    }
    public void setSettlementAccount(String settlementAccount) {
        this.settlementAccount = settlementAccount;
    }

    public String getBankCode(){
        return  bankCode;
    }
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public Date getDate(){

        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public static Payment createPayment(){
        Scanner in = new Scanner(System.in);
        Payment payment = new Payment();
        try {
            System.out.print("Enter a payment purpose: ");
            payment.setPurpose(in.nextLine());

            System.out.print("Enter a payment amount: ");
            payment.setAmount(Double.parseDouble(in.nextLine()));

            System.out.print("Enter bank: ");
            payment.setBankCode(in.nextLine());

            System.out.print("Enter settlement account code: ");
            payment.setSettlementAccount(in.nextLine());

            payment.setDate(new Date());
        }
        catch (InputMismatchException e) {
            System.out.println("Cannot create payment, " + e.getMessage());
            System.exit(1);
        }


        return  payment;
    }

    // toString() override
    @Override
    public String toString() {
        StringBuilder payment = new StringBuilder();

        payment.append("Payment N").append(number)
                .append("\nPurpose: ").append(purpose)
                .append("\nAmount: ").append(amount)
                .append("\nBank: ").append(bankCode)
                .append("\nAccount code: ").append(settlementAccount)
                .append("\nDate: ").append(date)
                .append("\n_________________________________________");

        return payment.toString();
    }
}
