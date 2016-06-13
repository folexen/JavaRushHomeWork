package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static HashSet<Integer> createSet()
    {
        //напишите тут ваш код
        HashSet<Integer> int_1 = new HashSet<Integer>();
        for (int i = 0; i < 20; i++)
        {
            int_1.add(i+1);
        }
        return int_1;

    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
        //напишите тут ваш код
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext())
        {
            int num = iterator.next();
            if (num > 10)
                iterator.remove();
        }
        return set;
    }
    public static void main(String[] args)
{
    System.out.println(removeAllNumbersMoreThan10(createSet()));
}
}

