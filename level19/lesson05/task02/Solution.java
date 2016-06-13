package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(r.readLine());
        Scanner sc = new Scanner(fileReader);
        int count = 0;
        while (sc.hasNext())
        {
            String s = sc.nextLine();
            String[] array = s.split("[,\\.\\!\\?\\:\\;\\-\\ ]");
            for (int i = 0; i < array.length; i++)
            {
                if (array[i].equals("world")) count++;
            }
        }
        System.out.println(count);
        r.close();
        fileReader.close();
        sc.close();
    }
}
