package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Flex on 25.11.2015.
 */
class DepositCommand implements Command
{
    Locale curLoc = new Locale("en");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit", curLoc);
    @Override
    public void execute() throws InterruptOperationException
    {
        try
        {
            String currencyCode = ConsoleHelper.askCurrencyCode();
            String[] denoCount = ConsoleHelper.getValidTwoDigits(currencyCode);
            ConsoleHelper.writeMessage(res.getString("before"));
            CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode).addAmount(Integer.parseInt(denoCount[0]), Integer.parseInt(denoCount[1]));
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), Integer.parseInt(denoCount[0])*Integer.parseInt(denoCount[1]), currencyCode));
        }
        catch (Exception e)
        {
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }

    }
}
