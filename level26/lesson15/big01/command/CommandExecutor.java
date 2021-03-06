package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.Operation;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Flex on 25.11.2015.
 */
public class CommandExecutor
{
    private CommandExecutor()
    {
    }

    private static Map<Operation, Command> commandMap;
    static
    {
        commandMap = new HashMap<>();
        commandMap.put(Operation.DEPOSIT, new DepositCommand());
        commandMap.put(Operation.EXIT, new ExitCommand());
        commandMap.put(Operation.INFO, new InfoCommand());
        commandMap.put(Operation.WITHDRAW, new WithdrawCommand());
        commandMap.put(Operation.LOGIN, new LoginCommand());
    }
    public static final void execute(Operation operation) throws InterruptOperationException
    {
            commandMap.get(operation).execute();
    }
}
