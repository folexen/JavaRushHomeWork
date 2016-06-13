package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileReader fr1 = new FileReader(r.readLine());
        FileWriter fr2 = new FileWriter(r.readLine());
        while (fr1.ready())
        {
            int data = fr1.read();
            int dat1 = fr1.read();
            fr2.write(dat1);

        }
        r.close();
        fr1.close();
        fr2.close();
    }
}
