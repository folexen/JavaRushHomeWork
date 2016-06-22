package com.javarush.test.level25.lesson09.task03;

/* Живем своим умом
В классе Solution реализуйте интерфейс UncaughtExceptionHandler, который должен:
1. прервать нить, которая бросила исключение.
2. вывести в консоль стек исключений начиная с самого вложенного.
Пример исключения: new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))
Пример вывода:
java.lang.IllegalAccessException: GHI
java.lang.RuntimeException: DEF
java.lang.Exception: ABC
*/

import java.util.ArrayList;

public class Solution implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        ArrayList<Throwable> list = new ArrayList<>();
        if (e != null)
        {
            Throwable eStack = e;
            list.add(0, eStack);
            while (eStack.getCause() != null)
            {
                eStack = eStack.getCause();
                list.add(0, eStack);
            }
            for (Throwable th : list)
            {
                System.out.println(th.getClass().getName() + ": " + th.getMessage());
            }
        }
    }
        public static void main(String[] args){
            Throwable e =  new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
            new Solution().uncaughtException(Thread.currentThread(), e);

        }
    }

