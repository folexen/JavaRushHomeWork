package com.javarush.test.level25.lesson05.home01;

/**
 * Created by Flex on 17.11.2015.
 */
public class LoggingStateThread extends Thread{


    Thread thread;
    public LoggingStateThread(Thread target)
    {
        this.thread = target;
        setDaemon(true);

    }
    public void run()
    {
        Thread.State state = thread.getState();
        System.out.println(state);
        while (state != State.TERMINATED)
        {
            if (state != thread.getState())
            {
                state = thread.getState();
                System.out.println(thread.getState());
            }
        }

    }

}