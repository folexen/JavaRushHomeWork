package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        int[] object1 = {1, 5, 7, 9 , 0};
        int[] object2 = {1, 2};
        int[] object3 = {1, 5, 7, 9};
        int[] object4 = {1, 2, 3, 4, 5, 6, 7};
        int[] object5 = new int[0];
        ArrayList<int[]> list = new ArrayList<int[]>();
        list.add(object1);
        list.add(object2);
        list.add(object3);
        list.add(object4);
        list.add(object5);
        return list;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array: list ) {
            for (int x: array) {
                System.out.println(x);
            }
        }
    }
}
