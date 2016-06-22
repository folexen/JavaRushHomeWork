package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream FIS = new FileInputStream(r.readLine());
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        while (FIS.available() > 0)
        {
            int data = FIS.read();
            if (!map.containsKey(data)) map.put(data, 0);
            else
            {
                for (Map.Entry<Integer, Integer> pair : map.entrySet())
                {
                    int a = pair.getKey();
                    int b = pair.getValue();
                    if (a == data) {int new_value= b+1; map.put(data, new_value);}
                }
            }
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> pair : map.entrySet())
        {
            if (pair.getValue() > max) max = pair.getValue();
        }
        for (Map.Entry<Integer, Integer> pair : map.entrySet())
        {
            if (pair.getValue() == max) System.out.print(pair.getKey() + " ");
        }
        FIS.close();
    }
}
