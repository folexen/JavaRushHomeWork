package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //add your code here
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        FileInputStream FIS = new FileInputStream(s);
        while (FIS.available() > 0) {
            System.out.print((char) FIS.read());
        }
        FIS.close();
    }
}
