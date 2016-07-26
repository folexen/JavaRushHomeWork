package com.javarush.test.level08.lesson11.home03;

import java.util.HashMap;
import java.util.Map;

/* Люди с одинаковыми именами и/или фамилиями
1. Создать словарь Map (<String, String>) и добавить туда 10 человек в виде «Фамилия»-«Имя».
2. Пусть среди этих 10 человек есть люди с одинаковыми именами.
3. Пусть среди этих 10 человек есть люди с одинаковыми фамилиями.
4. Вывести содержимое Map на экран.
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        HashMap<String, String> name_map = new HashMap<String, String>();
        name_map.put("Surname1", "Name1");
        name_map.put("Surname2", "Name2");
        name_map.put("Surname3", "Name3");
        name_map.put("Surname1", "Name4");
        name_map.put("Surname5", "Name5");
        name_map.put("Surname2", "Name6");
        name_map.put("Surname7", "Name7");
        name_map.put("Surname8", "Name8");
        name_map.put("Surname9", "Name1");
        name_map.put("Surname10", "Name2");
        return name_map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }

}
