package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String file1 = r.readLine();
        String file2 = r.readLine();
        FileInputStream fis = new FileInputStream(file1);
        byte[] buffer1 = new byte[fis.available()];
        while(fis.available() > 0)
        {
            int data1 = fis.read(buffer1);
        }
        FileInputStream fis2 = new FileInputStream(file2);
        FileOutputStream fos = new FileOutputStream(file1, false);
        while(fis2.available() > 0)
        {
            fos.write(fis2.read());
        }
        for (int i = 0; i < buffer1.length; i++)
        {
            fos = new FileOutputStream(file1, true);
            fos.write(buffer1[i]);
        }
        fos.close();
        fis.close();
        fis2.close();
        r.close();

    }
}
