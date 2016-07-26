package com.javarush.test.level08.lesson11.home08;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Пять наибольших чисел
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Вывести пять наибольших чисел.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }
        sort(array);
        for (int i = 0; i < 5; i++) {
            System.out.println(array[i]);
        }
    }

    public static void sort(int[] array) {
        //напишите тут ваш код
        int tmp;
        for (int j = 0; j < array.length; j++) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] < array[i+1]) {
                    tmp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = tmp;
                }
            }
        }
    }
}
