package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Map<Integer, Integer> symb = new TreeMap<>();
        FileReader fileReader = new FileReader(args[0]);

        while (fileReader.ready())
        {
            int data = fileReader.read();

                    int count = 1;
                    for (Map.Entry<Integer, Integer> pair : symb.entrySet())
                    {
                        if (data == pair.getKey()) count =count + pair.getValue();
                    }
                    symb.put(data, count);
        }

        for (Map.Entry<Integer, Integer> pair : symb.entrySet())
        {
            System.out.println((char)Integer.parseInt(pair.getKey().toString()) + " " + pair.getValue());
        }
        fileReader.close();

    }
}
