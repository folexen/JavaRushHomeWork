package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/


import java.io.*;
import java.util.Map;
import java.util.TreeMap;


public class Solution {
    public static void main(String[] args) throws IOException
    {
        Map<Integer, String> map = new TreeMap<>();
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {
            String s = r.readLine();
            if (s.equals("end")) break;
            int key = Integer.parseInt(s.substring(s.lastIndexOf(".")+5));
            map.put(key, s);
        }
        r.close();
        if (map.isEmpty()) System.out.println("No Files to Concat");
        else
        {
            for (Map.Entry<Integer, String> pair : map.entrySet())
            {
                String file_path = pair.getValue();
                String file_concated = file_path.substring(0, file_path.lastIndexOf("."));
                File file = new File(file_concated);
                if (!file.exists()) file.createNewFile();
                FileInputStream fis = new FileInputStream(file_path);
                FileOutputStream fos;
                byte[] buffer = new byte[fis.available()];
                while (fis.available() > 0)
                {
                    int data = fis.read(buffer);
                    fos = new FileOutputStream(file_concated, true);
                    fos.write(buffer);
                    fos.close();
                }
                fis.close();
            }
        }
    }
}
