package com.javarush.test.level36.lesson08.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Использование TreeSet
Первым параметром приходит имя файла: файл1.
файл1 содержит только буквы латинского алфавита, пробелы, знаки препинания, тире, символы перевода каретки.
Отсортировать буквы по алфавиту и вывести на экран первые 5 различных букв в одну строку без разделителей.
Если файл1 содержит менее 5 различных букв, то вывести их все.
Буквы различного регистра считаются одинаковыми.
Регистр выводимых букв не влияет на результат.
Закрыть потоки.

Пример 1 данных входного файла:
zBk yaz b-kN
Пример 1 вывода:
abkny

Пример 2 данных входного файла:
caAC
A, aB? bB
Пример 2 вывода:
abc

Подсказка: использовать TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        TreeSet<Character> characterTreeSet = new TreeSet<>();
        while (bufferedReader.ready())
        {
            String s = bufferedReader.readLine();
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++)
            {
                if (String.valueOf(chars[i]).matches("[a-z]"))
                {
                    characterTreeSet.add(chars[i]);
                }
            }
        }
        int counter = 0;
        for (Character c: characterTreeSet)
        {
            System.out.print(c);
            counter++;
            if (counter == 5) break;
        }

    }

}
