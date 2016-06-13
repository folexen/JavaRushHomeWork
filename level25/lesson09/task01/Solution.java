package com.javarush.test.level25.lesson09.task01;

/* Поживем - увидим
Все исключения, которые возникают в процессе работы нити Solution, должны быть обработаны одним из вариантов:
1. Если это Error, то вывести в консоль "Нельзя дальше работать"
2. Если это Exception, то вывести в консоль "Надо обработать"
3. Если это Throwable, то вывести в консоль "ХЗ"
Реализуйте эту логику.
*/
public class Solution extends Thread {
    public Solution() {
        this.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());

    }

    private class MyUncaughtExceptionHandler implements UncaughtExceptionHandler
    {
        @Override
        public void uncaughtException(Thread thread, Throwable throwable)
        {
            if (throwable instanceof Error)
            {
                System.out.println("Нельзя дальше работать");
                thread.interrupt();
                return;
            }
            if (throwable instanceof Exception)
            {
                System.out.println("Надо обработать");
                thread.start();
                return;
            }
            if (throwable instanceof Throwable)
            {
                System.out.println("ХЗ");
                thread.interrupt();
            }
        }
    }
}

