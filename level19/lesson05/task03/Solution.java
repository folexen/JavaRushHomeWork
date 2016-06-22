package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileReader fr = new FileReader(r.readLine());
        FileWriter fw = new FileWriter(r.readLine());
        Scanner sc = new Scanner(fr);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNext())
        {
            String s = sc.nextLine();
            String[] array = s.split("[\\ \\!\\?\\;\\:\\-]");
            for (int i = 0; i < array.length; i++)
            {
                try
                {
                    Integer.parseInt(array[i]);
                    fw.write(array[i]);
                    fw.write(" ");
                }
                catch (Exception e)
                {
                }
            }
        }
        fr.close();
        fw.close();
        r.close();
        sc.close();
    }
}
