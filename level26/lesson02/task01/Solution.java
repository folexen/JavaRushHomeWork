package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        //implement logic here
        if (array.length == 0)
            return new Integer[]{};
        Arrays.sort(array);
        final float medium;
        if (array.length % 2 == 0)
            medium = (array[array.length/2 - 1] + array[array.length/2]) / 2;
        else
            medium = array[array.length/ 2];
        Comparator<Integer> compareByMediana = new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                if(Math.abs(medium-o1) - Math.abs(medium-o2)!=0)
                    return (int)(Math.abs(medium-o1) - Math.abs(medium-o2));
                else
                    return (o1-o2);
            }
        };
        Arrays.sort(array, compareByMediana);
        return array;

    }
    public static void main(String args[])
    {
        Integer[] array = {5, 11, 13,  15, 17};
        array = sort(array);
        for(Integer x: array)
            System.out.print(x+" ");
    }
}
