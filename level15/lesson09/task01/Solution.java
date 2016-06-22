package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static
    {
        labels.put(523d, "String");
        labels.put(521d, "String2");
        labels.put(23d, "String3");
        labels.put(53d, "String4");
        labels.put(3d, "String5");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
