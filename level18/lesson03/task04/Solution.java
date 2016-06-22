package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r =  new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        ArrayList<Integer> array = new ArrayList<Integer>();
        FileInputStream FIS = new FileInputStream(s);
        while (FIS.available() > 0)
        {
            array.add(FIS.read());
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.size(); i++)
        {
            int tmp = array.get(i);
            int count = 0;
            for (int j = i+1; j < array.size()-1; j++)
            {
                if (array.get(j) == tmp)
                {
                    count++;
                    array.remove(j);
                }
            }
            map.put(tmp, count);
        }
        int min = 100000;
        for (Map.Entry<Integer, Integer> pair : map.entrySet())
        {
            min = pair.getValue();
            for (Map.Entry<Integer, Integer> pair2 : map.entrySet())
            {
                if (pair2.getValue() <= min) min = pair2.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> pair : map.entrySet())
        {
            int key = pair.getKey();
            int value = pair.getValue();
            if (value == min) System.out.print(key + " ");
        }
        r.close();
        FIS.close();
    }
}
