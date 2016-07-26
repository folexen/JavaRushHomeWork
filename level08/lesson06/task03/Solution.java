package com.javarush.test.level08.lesson06.task03;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* Измерить сколько времени занимает 10 тысяч вставок для каждого списка
Измерить, сколько времени занимает 10 тысяч вставок для каждого списка.
Метод getTimeMsOfInsert  должен вернуть время его исполнения в миллисекундах.
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getTimeMsOfInsert(new ArrayList()));
        System.out.println(getTimeMsOfInsert(new LinkedList()));
    }

    public static long  getTimeMsOfInsert(List list) {
        //напишите тут ваш код
        Date StartTime = new Date();
        long a = StartTime.getTime();
        insert10000(list);
        //напишите тут ваш код
        Date EndTime = new Date();
        long b = EndTime.getTime();
        long c = b - a;
        return c;
    }

    public static void insert10000(List list) {
        for (int i=0;i<10000;i++) {
            list.add(0, new Object());
        }
    }
}
