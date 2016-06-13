package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String file = r.readLine();
        r.close();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer;
        int max = 0;
        while (reader.ready())
        {
           String s = reader.readLine();
            s = s.substring(0,8);
            if (Integer.parseInt(s.trim())> max) max = Integer.parseInt(s.trim());
        }
        reader.close();
        if (args[0].equals("-c"))
        {
            StringBuilder sb = new StringBuilder();
            String name = "";
            for (int i = 1; i < args.length-2; i++) name +=args[i].concat(" ");
            sb = sb.append(stretch(8, String.valueOf(max+1))).append(stretch(30, name))
                    .append(stretch(8, args[args.length-2])).append(stretch(4, args[args.length-1]));
            writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(String.valueOf(sb) + System.getProperty("line.separator"));
            writer.close();
        }
    }
    public static String stretch(int length, String string)
    {
        StringBuilder sb = new StringBuilder();
        char[] chars = string.toCharArray();
        if (chars.length >=length)
        {
            for (int i = 0; i < length; i++) sb.append(chars[i]);
        }
        else
        {
            for (int i = 0; i < chars.length; i++) sb.append(chars[i]);
            for (int i = 0; i < length - chars.length; i++) sb.append(" ");
        }
        return String.valueOf(sb);
    }
}

