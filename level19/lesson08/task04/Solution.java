package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
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
        StringBuilder sb = new StringBuilder(baos.toString().replaceAll("\\n|\\r",""));
        String[] s = baos.toString().split(" ");
        int c = 0;
        if (s[1].equals("+")) {c = Integer.parseInt(s[0]) + Integer.parseInt(s[2]);}
        if (s[1].equals("-")) {c = Integer.parseInt(s[0]) - Integer.parseInt(s[2]);}
        if (s[1].equals("*")) {c = Integer.parseInt(s[0]) * Integer.parseInt(s[2]);}
        sb = sb.append(c);
        System.out.println(sb);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

