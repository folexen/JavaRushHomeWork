package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream FIS1 = new FileInputStream(r.readLine());
        FileOutputStream FOS1 = new FileOutputStream(r.readLine());
        FileOutputStream FOS2 = new FileOutputStream(r.readLine());
        byte[] buffer = new byte[FIS1.available()];
        if (FIS1.available() > 0)
        {
            int mid = FIS1.available()/2 + FIS1.available()%2;
            int data = FIS1.read(buffer);
            FOS1.write(buffer, 0, mid);
            FOS2.write(buffer, mid, buffer.length - mid);
        }
        FIS1.close();
        FOS1.close();
        FOS2.close();
        r.close();
    }
}