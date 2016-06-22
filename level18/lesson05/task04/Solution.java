package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader( new InputStreamReader(System.in));
        FileInputStream FIS = new FileInputStream(r.readLine());
        FileOutputStream FOS = new FileOutputStream(r.readLine());
        r.close();
        byte[] buffer = new byte[FIS.available()];
        if (FIS.available() > 0)
        {
            int data = FIS.read(buffer);
            for (int i = 0; i < buffer.length; i++)
            {
                FOS.write(buffer[buffer.length-i-1]);
            }

        }
        FIS.close();
        FOS.close();
        r.close();
    }
}
