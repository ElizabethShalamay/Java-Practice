package com.company.Exceptions;

public class WrongDateFormatException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Wrong date format. It should be yyyy/mm/dd";
    }
}
