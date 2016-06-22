package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException{
        Map<String, Double> map = new HashMap<>();
        FileReader fr = new FileReader(args[0]);
        Scanner sc = new Scanner(fr);
        String name = "";
        double value;
        while (sc.hasNext())
        {
            String s = sc.nextLine();
            String[] array = s.split(" ");
            for (int i = 0; i < array.length-1; i++)
            {
                name +=array[i] + " ";
            }
            value = Double.parseDouble(array[array.length - 1]);
            if (!map.containsKey(name))
            {
                map.put(name, value);
            }
            else
            {
                for (Map.Entry<String, Double> pair : map.entrySet())
                {
                    String n = pair.getKey();
                    double v= pair.getValue();
                    if (n.equals(name))
                    {
                        v = v + value;
                        map.put(name, v);
                    }
                }
            }
            name = "";
        }
        double max = 0;
        for (Map.Entry<String, Double> pair : map.entrySet())
        {
            if (pair.getValue() > max) max = pair.getValue();
        }
        for (Map.Entry<String, Double> pair : map.entrySet())
        {
            if (pair.getValue() == max) System.out.println(pair.getKey());
        }
        sc.close();
        fr.close();
    }

}
