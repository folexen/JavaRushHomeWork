package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
        ArrayList<String>[] a = new ArrayList[10];
        for (int i = 0; i < 10; i++) {
            ArrayList<String> l = new ArrayList<String>();
            for (int j = 0; j < 20; j++) {
                l.add("list"+j);
            }
            a[i] = l;
        }
        return a;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list: arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}