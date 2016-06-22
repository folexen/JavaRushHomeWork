package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String fosS = r.readLine();
        FileOutputStream fos = new FileOutputStream(fosS, false);
        FileInputStream fis1 = new FileInputStream(r.readLine());
        FileInputStream fis2 = new FileInputStream(r.readLine());
        while (fis1.available() > 0)
        {
            fos.write(fis1.read());
        }
        while (fis2.available() > 0)
        {
            fos = new FileOutputStream(fosS, true);
            fos.write(fis2.read());
        }
        fos.close();
        fis1.close();
        fis2.close();
        r.close();
    }
}
