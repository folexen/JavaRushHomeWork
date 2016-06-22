package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Flex on 25.11.2015.
 */
class ExitCommand implements Command
{
    Locale curLoc = new Locale("en");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "exit", curLoc);
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));
        while (true)
        {
            String s = ConsoleHelper.readString();
            if (s.equals(res.getString("yes")))
            {
                ConsoleHelper.writeMessage(res.getString("thank.message"));
                break;
            }
            else
            {
                ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));
            }
        }


    }
}
