package com.javarush.test.level19.lesson08.task03;

/* Выводим только цифры
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить только цифры
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Вывести модифицированную строку в консоль.

Пример вывода:
12345678
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream printstream = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps_new = new PrintStream(baos);
        System.setOut(ps_new);
        testString.printSomething();
        System.setOut(printstream);
        StringBuilder sb = new StringBuilder();
        String s = baos.toString();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            try
            {
                Integer.parseInt(String.valueOf(chars[i]));
                sb = sb.append(chars[i]);
            }
            catch (Exception e){}
        }
        System.out.println(sb);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
