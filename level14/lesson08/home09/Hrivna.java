package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Flex on 02.09.2015.
 */
public class Hrivna extends Money {

    public Hrivna(double amount) {
        super(amount);
    }

    public String getCurrencyName() {
        return "HRN";
    }
}
