package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(r.readLine());
        int b = Integer.parseInt(r.readLine());
        if (a > b)
        {
            long x = a, y = b, t = 1;
            while (t != 0)
            {
                t = x%y;
                if (t == 0) System.out.println(y);
                else
                {
                    x = y;
                    y = t;
                }

            }

        }
        else
        {
            long x = b, y = a, t = 1;
            while (t != 0)
            {
                t = x%y;
                if (t == 0) System.out.println(y);
                else
                {
                    x = y;
                    y = t;
                }

            }

        }
    }
}