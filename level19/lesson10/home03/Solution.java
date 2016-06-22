package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException
    {
        BufferedReader fr = new BufferedReader(new FileReader(args[0]));
        String name = "";
        Calendar calendar = new GregorianCalendar();
        while (fr.ready())
        {
            String s = fr.readLine();
            String[] array = s.split(" ");
            int k = array.length-3;
            for (int i = 0; i < k; i++)
            {
                name += array[i] + " ";
            }
            name = name.trim();
            calendar.set(Integer.parseInt(array[k+2]), Integer.parseInt(array[k+1])-1, Integer.parseInt(array[k]));
            PEOPLE.add(new Person(name, calendar.getTime()));
            name = "";
        }
        fr.close();
    }
}
