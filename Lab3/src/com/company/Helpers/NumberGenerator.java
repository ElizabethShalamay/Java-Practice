package com.company.Helpers;

public class NumberGenerator {
    private static int _paymentNumber = 1;
    private static int _accountNumber = 1;
    private static int _bankNumber = 1;

    public static int getNextPaymentNumber(){
        return  _paymentNumber++;
    }

    public static int getNextAccountNumber(){
        return  _accountNumber++;
    }

    public static int getNextBankNumber(){
        return  _bankNumber++;
    }
}
