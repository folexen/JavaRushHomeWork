package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    public static int[] getNumbers(int N)
    {
        int[] result = null;

        List<Integer> list = new ArrayList<>();
        int[][] matrix = new int[16][10]; //i - степень/строка, j - цифра/столбец
        for (int i = 0; i < 16; i++){
            for (int j = 0; j < 10; j++){
                int pr = 1;
                for (int k = 0; k < i ; k++){
                    pr *= j;
                }
                matrix[i][j] = pr;
            }
        }


        for (int i = 1; i < N; i++) {
            int degree = getDegree(i);
            int input = i;
            int sum = 0;
            int k;

            do {
                k = input % 10;
                sum += matrix[degree][k];
            } while ( (input /= 10) > 0);

            if (sum == i) {
                list.add(i);
            }
        }
        result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public static int getDegree(int i) {
        int degree = 0;

        do {
            degree += 1;
        } while ( (i /= 10) > 0);

        return degree;
    }
    public static void main(String[] args)
    {

        Long t0 = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(123456780)));
        Long t1 = System.currentTimeMillis();
        System.out.println("Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024d) + " Mb.");
        System.out.println("Time: " + (t1 - t0) / 1000d + " sec.");
    }
}
