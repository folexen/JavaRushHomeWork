package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Flex on 01.12.2015.
 */
public class Producer implements Runnable
{
    protected ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map)
    {
        this.map = map;
    }

    @Override
    public void run()
    {
        int i = 1;
        try
        {
            while (true)
            {
                System.out.println("Some text for " + i);
                Thread.sleep(500);
                i++;
            }
        }
        catch (InterruptedException ex)
        {
            System.out.println("[" + Thread.currentThread().getName() + "]" + "thread was terminated");
        }

    }
}
