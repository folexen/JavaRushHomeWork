package com.javarush.test.level07.lesson12.home01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Вывести числа в обратном порядке
Ввести с клавиатуры 10 чисел и заполнить ими список.
Вывести их в обратном порядке.
Использовать только цикл for.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> num = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            num.add(Integer.parseInt(reader.readLine()));
        }
        for (int i = 0; i < num.size(); i++) {
            int x = num.size() - i - 1;
            System.out.println(num.get(x));
        }
    }
}
