package com.javarush.test.level08.lesson11.home04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Минимальное из N чисел
1. Ввести с клавиатуры число N.
2. Считать N целых чисел и заполнить ими список - метод getIntegerList.
3. Найти минимальное число среди элементов списка - метод getMinimum.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        // Найти минимум
        int tmp = 0;
        int[] num = new int[array.size()];
        for (int i = 0; i < num.length; i++) {
            num[i] = array.get(i);
        }
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length - 1; j++) {
                if (num[j] > num[j + 1]) {
                    tmp = num[j+1];
                    num[j+1] = num[j];
                    num[j] = tmp;
                }
            }
        }
          return num[0];
    }

    public static List<Integer> getIntegerList() throws IOException {
        //Тут создать и заполнить список
        BufferedReader r = new BufferedReader(new InputStreamReader((System.in)));
        int N = Integer.parseInt(r.readLine());
        ArrayList<Integer> integerList = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(r.readLine());
            integerList.add(n);
        }
        return integerList;
    }
}
