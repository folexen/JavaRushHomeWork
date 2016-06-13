package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[1]);
        FileOutputStream fos = new FileOutputStream(args[2]);
        byte[] buffer = new byte[fis.available()];
        String key = "JavaRushBest";
        if (args[0].equals("-e"))
        {
            while (fis.available() > 0)
            {
                int data = fis.read(buffer);
                byte[] b_key = key.getBytes();
                byte[] res = new byte[buffer.length];
                for (int i = 0; i < buffer.length; i++)
                {
                    res[i] = (byte) (buffer[i] ^ b_key[i % b_key.length]);
                }
                fos.write(res);
            }
            fis.close();
            fos.close();
        }
        if (args[0].equals("-d"))
        {
            while (fis.available() > 0)
            {
                int data = fis.read(buffer);
                byte[] res = new byte[buffer.length];
                byte[] b_key = key.getBytes();
                for (int i = 0; i < buffer.length; i++) {
                    res[i] = (byte) (buffer[i] ^ b_key[i % b_key.length]);
                }
                fos.write(res);
            }
            fis.close();
            fos.close();
        }
    }
}
