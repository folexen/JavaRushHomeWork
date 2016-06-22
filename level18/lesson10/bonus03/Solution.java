package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

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
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(reader.readLine());
        File tmp_file = new File(file.getAbsolutePath() + ".tmp");
        BufferedReader filereader = new BufferedReader(new FileReader(file));
        BufferedWriter filewriter = new BufferedWriter(new FileWriter(tmp_file));
        String comparator = "";
        if (args[1].length() < 8)
        {
            char[] tmp = args[1].toCharArray();
            for (int i = 0; i < tmp.length; i++) comparator += tmp[i];
            for (int i = 0; i < 8-tmp.length; i++) comparator += " ";
        }
        else
        {
            char[] tmp = args[1].toCharArray();
            for (int i = 0; i < 8; i++) comparator += tmp[i];
        }

        if (args[0].equals("-u"))
        {
            while (filereader.ready())
            {
                String s = filereader.readLine();
                if (s.startsWith(comparator))
                {
                    String name = "";
                    for (int i = 2; i < args.length -2; i++) name +=args[i].concat(" ");
                    StringBuilder sb = new StringBuilder();
                    sb = sb.append(stretch(8, args[1])).append(stretch(30, name)).append(stretch(8, args[args.length-2])).append(stretch(4, args[args.length-1]));
                    s = String.valueOf(sb);
                    filewriter.write(s + System.getProperty("line.separator"));
                }
                else filewriter.write(s + System.getProperty("line.separator"));
            }
            filereader.close();
            filewriter.close();
            file.delete();
            boolean renameTo = tmp_file.renameTo(file);
        }
        if (args[0].equals("-d"))
        {
            while (filereader.ready())
            {
                String s = filereader.readLine();
                if (!s.startsWith(comparator)) filewriter.write(s + System.getProperty("line.separator"));
            }

            filereader.close();
            filewriter.close();
            file.delete();
            boolean renameTo = tmp_file.renameTo(file);
        }
        reader.close();
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
