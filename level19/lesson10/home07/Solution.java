package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader fr = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fw = new BufferedWriter(new FileWriter(args[1]));
        String result = "";
        while (fr.ready())
        {
            String s = fr.readLine();
            String[] strings  = s.split(" ");
            for (int i = 0; i < strings.length; i++)
            {
                if (strings[i].length() > 6)
                {
                    result = result.concat(strings[i]).concat(",");
                }
            }
        }
        fw.write(result.substring(0, result.length() - 1));
        fw.close();
        fr.close();


    }
}
