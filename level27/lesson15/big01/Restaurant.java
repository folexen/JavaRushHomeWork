package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;


/**
 * Created by Flex on 22.06.2016.
 */
public class Restaurant {
    public static void main(String[] args) {
        Tablet tablet = new Tablet(5);
        Cook cook = new Cook("Lex");
        Waitor waitor = new Waitor();
        cook.addObserver(waitor);
        tablet.addObserver(cook);
        tablet.createOrder();
    }
}
