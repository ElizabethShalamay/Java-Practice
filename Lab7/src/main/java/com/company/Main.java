package com.company;
import Entities.*;
import Exceptions.*;
import org.apache.log4j.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    static Logger accountLogger = Logger.getLogger(Account.class);

    public static void main(String[] args) {
        Account account1 = initializeAccount();

        fillAccount(account1);

        searchForPayments(account1);
    }

    private static Account initializeAccount(){
        Scanner in = new Scanner(System.in);
        Account account;
        while(true){
            try {
                System.out.print("Enter account max size: ");
                int input = Integer.parseInt(in.nextLine());
                account = new Account(input);
                accountLogger.info("Account successfully created");
                return account;
            }
            catch (NumberFormatException e){
                accountLogger.error("Cannot create an account. En error occurred: " + e.getMessage());
                System.out.println("Wrong size format. Please try again");
            }
        }
    }

    private static void fillAccount(Account account){
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Would you like to create payment manually ('Yes' or 'No')? ");
            String input = in.nextLine();
            if (input.equals("No")){
                fillAccountWithPayments(account, getTestPayments());
                accountLogger.info("Payments were added automatically");
                break;
            }
            account.addPayment(Payment.createPayment());
            accountLogger.info("Payment was added manually");
        }
    }

    private static void searchForPayments(Account account){
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("Enter search type \n1. By purpose \n2. By amount \n3. By date range " +
                    "\n4. View all payments");
            String searchType = in.nextLine();
            switch (searchType){
                case "1": {
                    System.out.println("Enter expected payment purpose: ");
                    String purpose = in.nextLine();

                    System.out.println("Payments By Purpose");
                    Payment[] paymentsByPurpose = account.getPaymentsWithSpecificPurpose(purpose);
                    Account.displaySelectedPayments(paymentsByPurpose);
                    break;
                }
                case "2":{
                    System.out.println("Enter expected minimum payment amount: ");
                    try{
                        double expectedAmount = Double.parseDouble(in.nextLine());
                        System.out.println("Payments Larger Than " + expectedAmount);
                        try {
                            Payment[] paymentsLargerThanAmount = account.getLargerPayments(expectedAmount);
                            Account.displaySelectedPayments(paymentsLargerThanAmount);
                        }
                        catch (NegativeAmountException ex){
                            accountLogger.error(ex.getMessage());
                            System.err.println(ex.getMessage());
                            break;
                        }
                    }
                    catch (NumberFormatException e){
                        accountLogger.error(e.getMessage());
                        System.out.println("Wrong amount format. Please try again");
                    }
                    break;
                }
                case "3":{
                    System.out.println("Enter start date (yyyy/MM/dd): ");
                    Date startDate;
                    try {
                        startDate = parseDate(in.nextLine());

                        Date endDate;
                        System.out.println("Enter end date (yyyy/MM/dd): ");
                        endDate = parseDate(in.nextLine());

                        System.out.println("Payments In Date Range " + parseDate(startDate)
                                + " - " + parseDate(endDate));
                        Payment[] paymentsInDateRange = account.getPaymentsInDateRange(startDate, endDate);
                        Account.displaySelectedPayments(paymentsInDateRange);
                    }
                    catch (WrongDateFormatException ex){
                        accountLogger.error(ex.getMessage());
                        System.err.println(ex.getMessage());
                        break;
                    }
                    break;
                }
                case "4":{
                    Account.displaySelectedPayments(account.getPayments());
                    break;
                }
                default:{
                    System.out.println("Something went wrong. Please try again");
                    break;
                }
            }
        }
    }

    private  static Date parseDate(String dateString) throws WrongDateFormatException{
        SimpleDateFormat format = new SimpleDateFormat ("yyyy/MM/dd");

        Date date = new Date();
        try{
            date = format.parse(dateString);
        }
        catch (ParseException e) {
            throw new WrongDateFormatException();
        }
        return date;
    }

    private static String parseDate(Date date){
        SimpleDateFormat format = new SimpleDateFormat ("yyyy/MM/dd");

        return format.format(date);
    }

    private static Payment[] getTestPayments(){
        Payment payment1 = new Payment("For fun", 100, "PrivateBank",
                "1111 2222 3333 4444");
        Payment payment2 = new Payment("For future", 1000, "MonoBank",
                "1111 2222 3333 4444");
        Payment payment3 = new Payment("For future", 500, "MonoBank",
                "1111 2222 3333 4444", parseDate("2018/10/21"));
        Payment payment4 = new Payment("For travel", 100, "MonoBank",
                "1111 2222 3333 4444", parseDate("2016/11/01"));
        Payment payment5 = new Payment("Salary", 3500, "MonoBank",
                "1111 2222 3333 4444", parseDate("2004/07/15"));
        Payment payment6 = new Payment("Salary", 5000, "MonoBank",
                "1111 2222 3333 4444", parseDate("2005/04/03"));

        return  new Payment[]{payment1, payment2, payment3, payment4, payment5, payment6};
    }

    private static void fillAccountWithPayments(Account account, Payment[] payments){
        for (Payment payment: payments) {
            account.addPayment(payment);
        }
    }
}
