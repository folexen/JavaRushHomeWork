package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static void main(String[] args)
    {
        HashMap<String, String> map = createMap();
        System.out.println(getCountTheSameLastName(map, "Ta"));
        System.out.println(getCountTheSameFirstName(map, "John"));
    }

    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();

        map.put("q1","John");
        map.put("w2","John");
        map.put("a1","Pete");
        map.put("Scott","Nick");
        map.put("Smith","John");
        map.put("Glad","Cole");
        map.put("Bad","Brad");
        map.put("Ugly","Nick");
        map.put("Good","Cont");
        map.put("Smith","Stuck");

        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //напишите тут ваш код
        int count = 0;
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            Map.Entry<String, String> pair = iterator.next();
            String s = pair.getValue();
            if (s.equals(name))
                count++;

        }
        return count;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        //напишите тут ваш код

        return map.containsKey(familiya) ? 1 : 0;

    }
}
