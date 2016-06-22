package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import java.util.ConcurrentModificationException;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Flex on 25.11.2015.
 */
class WithdrawCommand implements Command
{
    Locale curLoc = new Locale("en");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw", curLoc);
    @Override
    public void execute() throws InterruptOperationException
    {
        String s = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currentCurrencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(s);
        while (true)
        {
                int currencyAmount = 0;
                try
                {
                    ConsoleHelper.writeMessage(res.getString("specify.amount"));
                    currencyAmount = Integer.parseInt(ConsoleHelper.readString());
                }
                catch (ParseException pe)
                {
                    ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                }
                try
                {
                    if (currentCurrencyManipulator.isAmountAvailable(currencyAmount))
                    {

                        for (Map.Entry<Integer, Integer> pair : currentCurrencyManipulator.withdrawAmount(currencyAmount).entrySet())
                        {
                            ConsoleHelper.writeMessage(res.getString("before"));
                            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), currencyAmount, s));
                        }
                        break;
                    }
                    else
                    {
                        ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                        break;
                    }
                }
                catch (NotEnoughMoneyException ex)
                {

                    ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                    break;
                }
                catch (ConcurrentModificationException ex)
                {
                    ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                    break;
                }

            }
    }
}
