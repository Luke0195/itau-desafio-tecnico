package br.com.desafioitau.app.utils;


import java.time.OffsetDateTime;


public class Validator {

    private Validator(){};

    public static boolean isDateInTheFutureComparedToNow(OffsetDateTime currentDate){
       return currentDate.isBefore(OffsetDateTime.now());
    };

    public static  boolean isGreaterThanZero(Double value){
        return  value > 0;
    }
}
