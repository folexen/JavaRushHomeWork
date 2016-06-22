package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileReader fr = new FileReader(r.readLine());
        FileWriter fw = new FileWriter(r.readLine());
        StringBuilder sb = new StringBuilder();
        while (fr.ready())
        {
            int data = fr.read();
            sb.append((char)data);
        }
        String s  = String.valueOf(sb).replaceAll("\\p{Punct}","");
        fw.write(s);
        fr.close();
        fw.close();
        r.close();
    }
}
