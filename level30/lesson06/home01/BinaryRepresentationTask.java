package com.javarush.test.level30.lesson06.home01;

import java.util.concurrent.RecursiveTask;

/**
 * Created by Flex on 28.12.2015.
 */
public class BinaryRepresentationTask extends RecursiveTask
{
    private int x;
    public BinaryRepresentationTask(int i)
    {
        this.x = i;
    }

    @Override
    protected Object compute()
    {

        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a);
        if (b > 0) {
            BinaryRepresentationTask task1 = new BinaryRepresentationTask(b);
            task1.fork();
            return task1.join() + result;
        }
        return result;
    }
}
