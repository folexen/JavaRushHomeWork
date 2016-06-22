package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        FileWriter writer = new FileWriter(args[1]);
        while (reader.ready())
        {
            String s = reader.readLine();
            String[] strings = s.split(" ");
            for (int i = 0; i < strings.length; i++)
            {
                if (strings[i].contains("1") || strings[i].contains("2") || strings[i].contains("3") || strings[i].contains("4") ||
                        strings[i].contains("5") || strings[i].contains("6") || strings[i].contains("7") || strings[i].contains("8") ||
                strings[i].contains("9") || strings[i].contains("0")) writer.write(strings[i] + " ");

            }
        }
        reader.close();
        writer.close();
    }
}
