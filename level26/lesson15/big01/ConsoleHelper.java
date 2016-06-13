package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ResourceBundle;


/**
 * Created by Flex on 25.11.2015.
 */
public class ConsoleHelper
{
    private static Locale curLoc = new Locale("en");
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common", curLoc);
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message)
    {
        System.out.println(message);

    }
    public static void printExitMessage()
    {
       writeMessage(res.getString("the.end"));
    }

    public static String readString()throws InterruptOperationException
    {

        String message = "";
        try
        {
           message = br.readLine();
            if (message.toLowerCase().equals("exit")) throw new InterruptOperationException();
        }
                catch (IOException ex)
        {

        }

        return message;
    }
    public static String askCurrencyCode() throws InterruptOperationException
    {
        writeMessage(res.getString("choose.currency.code"));
        String currencyCode = readString();
        while (currencyCode.length() !=3)
        {
            writeMessage(res.getString("invalid.data"));
            currencyCode = readString();
        }
        return currencyCode.toUpperCase();
    }
    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
        String string;
        String[] twoDigits;
        while (true)
        {

                string = readString();
                twoDigits = string.split(" ");
                int denomination = Integer.parseInt(twoDigits[0]);
                int count = Integer.parseInt(twoDigits[1]);
                if (denomination > 0 && count > 0 && twoDigits.length == 2) break;
        }
        return twoDigits;
    }
    public static Operation askOperation() throws InterruptOperationException
    {
        writeMessage(res.getString("choose.operation"));
        writeMessage(res.getString("operation.INFO") + " - 1.");
        writeMessage(res.getString("operation.DEPOSIT") + " - 2.");
        writeMessage(res.getString("operation.WITHDRAW") + " - 3.");
        writeMessage(res.getString("operation.EXIT") + " - 4");
        Operation operation;
        while (true)
        {
            try
            {
                int operNum = Integer.parseInt(readString());
                operation = Operation.getAllowableOperationByOrdinal(operNum);
                break;

            }
            catch (IllegalArgumentException ex)
            {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
        }
        return operation;
    }

}
