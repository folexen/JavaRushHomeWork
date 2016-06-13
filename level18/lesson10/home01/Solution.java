package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        char[] abc = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        FileInputStream fis = new FileInputStream(args[0]);
        Scanner sc = new Scanner(fis);
        int count = 0;
        String s = "";
        while (sc.hasNext())
        {
            s += sc.nextLine();
        }
        fis.close();
        sc.close();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            for (int j =0; j < abc.length; j++)
            if (chars[i] == abc[j]) count++;
        }
        System.out.println(count);
    }
}
