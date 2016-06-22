package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by Flex on 25.11.2015.
 */
interface Command
{
   void execute() throws InterruptOperationException;
}
