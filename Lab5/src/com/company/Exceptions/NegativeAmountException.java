package com.company.Exceptions;

public class NegativeAmountException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Amount of money is less then 0";
    }
}
