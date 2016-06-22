package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String small_url = url.substring(url.indexOf("?")+1, url.length());
        List<String> list = Arrays.asList(small_url.split("&"));
        String out = "";
        for (String i: list){
            if (i.contains("="))
            {
                out += (i.substring(0, i.indexOf("=")) + " ");
            }
            else out += i + " ";
        }
        System.out.println(out.trim());
        for (String i: list){
            if (i.startsWith("obj=")){
                try
                {
                    alert(Double.parseDouble(i.substring(4)));
                }
                catch (Exception e){
                    alert(i.substring(4));
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
