package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by Flex on 25.11.2015.
 */
public class CurrencyManipulator
{
    private String currencyCode;
    public Map<Integer, Integer> denominations;

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
        this.denominations = new HashMap<>();
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }
    public void addAmount(int denomination, int count)
    {
        if (denominations.containsKey(denomination))
        {
            int value = denominations.get(denomination) + count;
            denominations.put(denomination, value);
        }
        else
        {
            denominations.put(denomination, count);
        }
    }
    public int getTotalAmount()
    {
        int totalAmount = 0;
        for (Map.Entry<Integer, Integer> pair : denominations.entrySet())
        {
            totalAmount += pair.getValue()*pair.getKey();
        }
        return totalAmount;
    }
    public boolean hasMoney()
    {
        boolean result=true;
        if (denominations.isEmpty()) result = false;
        else {
            int zerosCount=0;
            for (Map.Entry<Integer,Integer> pair : denominations.entrySet()){
                if (pair.getValue()==0) zerosCount++;
            }
            if (zerosCount==denominations.size()) result=false;
        }
        return result;
    }
    public boolean isAmountAvailable(int expectedAmount)
    {
        int sum = 0;
        for (Map.Entry<Integer, Integer> pair : denominations.entrySet())
        {
            sum +=pair.getKey()*pair.getValue();
        }
        if (sum >= expectedAmount)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        Map<Integer, Integer> sortedDenominations = new TreeMap<>(Collections.reverseOrder());
        Map<Integer, Integer> withdrawDenominations = new TreeMap<>(Collections.reverseOrder());
        sortedDenominations.putAll(denominations);
        for (Map.Entry<Integer, Integer> pair : sortedDenominations.entrySet())
        {
            Integer count = expectedAmount/pair.getKey();
            if (count !=0)
            {
                if (count < pair.getValue())
                {
                    expectedAmount -= pair.getKey()*count;
                    withdrawDenominations.put(pair.getKey(), count);
                }
                else
                {
                    expectedAmount -= pair.getKey()*pair.getValue();
                    withdrawDenominations.put(pair.getKey(), pair.getValue());
                }
            }
            if (expectedAmount == 0) break;
        }
        if (expectedAmount != 0)
        {
            throw new NotEnoughMoneyException();
        }
        else
        {
            for (Map.Entry<Integer, Integer> pair : withdrawDenominations.entrySet())
            {
                if ((denominations.get(pair.getKey()) - pair.getValue()) == 0)
                {
                    denominations.remove(pair.getKey());
                }
                else
                {
                    denominations.put (pair.getKey(), denominations.get(pair.getKey()) - pair.getValue());
                }
            }
        }
        return withdrawDenominations;
    }


}
