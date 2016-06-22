package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Flex on 22.06.2016.
 */
public class Cook extends Observable implements Observer{
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name;
    }

    @Override
    public void update(Observable observable, Object o)
    {
        ConsoleHelper.writeMessage("Start cooking - " + o.toString());
        setChanged();
        notifyObservers(o);
    }
}
