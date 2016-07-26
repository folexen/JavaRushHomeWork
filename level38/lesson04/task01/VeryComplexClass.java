package com.javarush.test.level38.lesson04.task01;

/* Проверяемые исключения (checked exception)
Напиши реализацию метода veryComplexMethod().
Он должен всегда кидать какое-нибудь проверяемое исключение.
Кинуть исключение (throw) явно нельзя.
*/

import java.util.Map;
import java.util.TreeMap;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        //напишите тут ваш код
        Map<String, String> treeMap = new TreeMap();
        treeMap.put(null, null);
    }
}