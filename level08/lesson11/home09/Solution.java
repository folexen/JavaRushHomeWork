package com.javarush.test.level08.lesson11.home09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        System.out.println(isDateOdd(s));
    }

    public static boolean isDateOdd(String date) {
        Date YST = new Date();
        YST.setHours(0);
        YST.setMinutes(0);
        YST.setSeconds(0);
        YST.setMonth(0);
        YST.setDate(1);

        Date YCT = new Date(date);
        long time_ms = YCT.getTime() - YST.getTime();
        long ms_day = 24 * 60 * 60 * 1000;
        int days = (int)(time_ms/ms_day);
        if ((days+1) % 2 != 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
