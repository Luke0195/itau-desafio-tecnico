package br.com.desafioitau.app.utils;


import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;


@Component
public class Validator {

    private Validator(){};

    public  boolean isDateInTheFutureComparedToNow(OffsetDateTime currentDate){
       return currentDate.isBefore(OffsetDateTime.now());
    };

    public  boolean isGreaterThanZero(Double value){
        return  value > 0;
    }



}
