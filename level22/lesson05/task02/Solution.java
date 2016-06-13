package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static void main(String[] args) throws TooShortStringException
    {
        System.out.println(getPartOfString("Vinod"+"\t"+"Kumar"+"\t"+"Nair"));
    }
    public static String getPartOfString(String string) throws TooShortStringException{
        if (string ==null) throw new TooShortStringException();
        int count = 0;
        int end = 0;
        char[] tmp = string.toCharArray();
        for (int i = 0; i < tmp.length; i++)
        {
            if (tmp[i] == '\t') count++;
            if (count == 2)
            {
                end = i;
                break;
            }
        }
        if (count < 2) throw new TooShortStringException();

        return string.substring(string.indexOf("\t")+1, end);
    }

    public static class TooShortStringException extends Exception {
    }
}
