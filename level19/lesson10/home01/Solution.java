package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        Map<String, Double> map = new TreeMap<>();
        BufferedReader fr = new BufferedReader(new FileReader(args[0]));
        while (fr.ready())
        {
            String s = fr.readLine();
            String[] array = s.split(" ");
            String name = "";
            double salary = 0;
            StringBuilder sb = new StringBuilder(name);
            for (int i = 0; i < array.length - 1; i++)
            {
                sb = sb.append(array[i]).append(" ");
            }
            salary = Double.parseDouble(array[array.length - 1]);
            name = String.valueOf(sb).trim();
            if (map.containsKey(name))
            {
                for (Map.Entry<String, Double> pair : map.entrySet())
                {
                    if (pair.getKey().equals(name))
                    {
                        double tmp = pair.getValue() + salary;
                        map.put(name, tmp);
                    }
                }
            }
            else map.put(name, salary);
        }
        for (Map.Entry<String, Double> pair : map.entrySet())
        {
            System.out.println(pair.getKey().concat(" ").concat(String.valueOf(pair.getValue())));
        }
        fr.close();
    }
}
