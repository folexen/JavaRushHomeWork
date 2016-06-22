package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Flex on 22.06.2016.
 */
public class Waitor implements Observer{

    @Override
    public void update(Observable observable, Object o)
    {
        ConsoleHelper.writeMessage(o.toString() + " was cooked by " + observable.toString());
    }
}
