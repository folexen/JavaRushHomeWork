package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        int[] num = new int[5];
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(reader.readLine());
        }
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length - 1; j++) {
                int tmp1 = 0;
                if (num[j] > num[j+1]) {
                     tmp1 = num[j];
                    num[j] = num[j+1];
                    num[j+1] = tmp1;
                }
            }
        }
        for (int i = 0; i < num.length; i++){
        System.out.println(num[i]);
        }
    }
}
