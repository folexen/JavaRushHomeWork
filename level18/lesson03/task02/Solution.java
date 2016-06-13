package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream FIS = new FileInputStream(r.readLine());
        int min = 32767;
        while (FIS.available() > 0)
        {
            int data = FIS.read();
            if (data < min) min = data;
        }
        System.out.println(min);
        FIS.close();
    }
}
