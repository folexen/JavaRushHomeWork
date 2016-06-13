package com.javarush.test.level17.lesson10.home09;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args)
    {

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis1, fis2;
        try
        {
            fis1 = new FileInputStream(r.readLine());
            fis2 = new FileInputStream(r.readLine());
            Scanner sc = new Scanner(fis1);
            while (sc.hasNext())
            {
                allLines.add(sc.nextLine());
            }
            sc.close();
            Scanner sc2 = new Scanner(fis2);
            while (sc2.hasNext())
            {
                forRemoveLines.add(sc2.nextLine());
            }
            sc2.close();
            r.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        try
        {
            new Solution().joinData();
        }
        catch (CorruptedDataException e)
        {
            e.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException
    {

       if (allLines.containsAll(forRemoveLines))
       {
           allLines.removeAll(forRemoveLines);
           return;
       }
       for (String s : forRemoveLines)
       {
           if (!allLines.contains(s))
           {
               allLines.clear();
               throw new CorruptedDataException();
           }
       }
    }
}
