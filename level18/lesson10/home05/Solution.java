package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
       Scanner sc = new Scanner(new FileInputStream(r.readLine()));
        PrintWriter writer = new PrintWriter(new FileOutputStream(r.readLine()));
        while (sc.hasNext())
        {
            String s = sc.nextLine();
            String[] array = s.split(" ");
            for (int i = 0; i < array.length; i++)
            {
                writer.write(Long.toString(Math.round(Double.parseDouble(array[i]))) + " ");
            }
        }
        writer.close();
        r.close();
        sc.close();
    }
}
