package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        // напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        InputStream fis = new FileInputStream(s);
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> even = new ArrayList<Integer>();
        Scanner sc = new Scanner(fis);
        while (fis.available() > 0)
        {
            while(sc.hasNextInt()){int data = sc.nextInt(); list.add(data);}
        }

        for (int i = 0; i < list.size(); i++){
            if (list.get(i)%2==0 || list.get(i) == 0) even.add(list.get(i));
        }
        int[] num = new int[even.size()];
        for (int i = 0; i < even.size(); i++) num[i]=even.get(i);
        for (int i = 0; i < num.length; i++)
        {
            for (int j = 0; j < num.length - 1; j++)
            {
                int tmp;
                if (num[j] > num[j+1])
                {
                    tmp = num[j+1];
                    num[j+1] = num[j];
                    num[j] = tmp;
                }
            }
        }
        for (int i = 0; i < num.length; i++) System.out.println(num[i]);
    }
}
