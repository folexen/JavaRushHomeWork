package com.javarush.test.level30.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Flex on 29.12.2015.
 */
public class ConsoleHelper
{

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString()
    {
        String string = null;
         while (true)
         {
             try
             {
                 string = bufferedReader.readLine();
                 break;
             }
             catch (IOException ex)
             {
                 writeMessage("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
             }
         }
        return string;
    }

    public static int readInt()
    {
        int number = 0;
        while (true)
        {
            try
            {
                number = Integer.parseInt(readString());
                break;
            }
            catch (NumberFormatException ex)
            {
                writeMessage("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        }
        return number;
    }
}
