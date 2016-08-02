package com.javarush.test.level09.lesson11.home09;

import java.util.*;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<String> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        Map<String, Cat> map = new HashMap<String, Cat>();
        for (int i = 1; i < 11; i++) {
            String name = "Cat" + i;
            Cat cat = new Cat(name);
            map.put(cat.name, cat);
        }
        return map;
    }

    public static Set<String> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        Set<String> catSet = new HashSet<String>();
        Iterator<Map.Entry<String, Cat>> it = map.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, Cat> pair = it.next();
            String cat = pair.getKey();
            catSet.add(cat);

        }
        return catSet;
    }

    public static void printCatSet(Set<String> set) {
        for (String cat:set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat "+this.name;
        }
    }
}
