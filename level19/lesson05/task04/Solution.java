package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileReader fr = new FileReader(r.readLine());
        FileWriter fw = new FileWriter(r.readLine());
        while (fr.ready())
        {
            int c = fr.read();
            if ((char)c == '.')
            {
                c = '!';
            }
            fw.write(c);
        }
        r.close();
        fr.close();
        fw.close();
    }
}
