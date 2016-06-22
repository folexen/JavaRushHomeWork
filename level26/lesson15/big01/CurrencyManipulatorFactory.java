package com.javarush.test.level26.lesson15.big01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Flex on 25.11.2015.
 */
public class CurrencyManipulatorFactory
{
    private CurrencyManipulatorFactory()
    {

    }

    private static Map<String, CurrencyManipulator> currencyManipulators = new HashMap<>();

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode)
    {
        if  (!currencyManipulators.containsKey(currencyCode))
        {
            currencyManipulators.put(currencyCode, new CurrencyManipulator(currencyCode));
        }

        return currencyManipulators.get(currencyCode);

    }
    public static Collection getAllCurrencyManipulators()
    {
        ArrayList<CurrencyManipulator> curMan = new ArrayList<>();
        curMan.addAll(currencyManipulators.values());
        return  curMan;
    }
}
