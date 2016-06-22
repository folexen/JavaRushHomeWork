package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Flex on 27.11.2015.
 */
public class LoginCommand implements Command
{
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    Locale curLoc = new Locale("en");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login", curLoc);
    @Override
    public void execute() throws InterruptOperationException
    {


        String enteredLogin;
        String enteredPwd;
        while (true)
        {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            enteredLogin = ConsoleHelper.readString();
            enteredPwd = ConsoleHelper.readString();
            if (enteredLogin.length() != 12 && enteredPwd.length() !=4)
            {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }
            if (validCreditCards.containsKey(enteredLogin) && !(validCreditCards.getString(enteredLogin).equals(enteredPwd)))
            {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), enteredLogin));
            }
            if (!(validCreditCards.containsKey(enteredLogin) && validCreditCards.getString(enteredLogin).equals(enteredPwd)))
            {
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                continue;
            }

            else
            {
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), enteredLogin));
                break;
            }
        }
    }
}
