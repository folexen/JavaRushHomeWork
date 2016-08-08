package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        FileOutputStream fos = new FileOutputStream(s);
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String tmp = r.readLine();
                list.add(tmp);
                if (tmp.equals("exit")) break;
            }
        String lineSeparator = System.getProperty("line.separator");
        for (int i = 0; i < list.size(); i++) {
            fos.write(list.get(i).getBytes());
            fos.write(lineSeparator.getBytes());
        }
        fos.close();
    }
}
