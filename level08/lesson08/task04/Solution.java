package com.javarush.test.level08.lesson08.task04;

import java.text.DateFormat;
import java.util.*;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{

    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Stallone1", new Date("JUNE 1 1980"));
        map.put("Stallone2", new Date("JUNE 1 1980"));
        map.put("Stallone3", new Date("SEPTEMBER 1 1980"));
        map.put("Stallone4", new Date("JUNE 1 1980"));
        map.put("Stallon5", new Date("DECEMBER 1 1980"));
        map.put("Stallone6", new Date("JUNE 1 1980"));
        map.put("Stallone7", new Date("MAY 1 1980"));
        map.put("Stallon8", new Date("JUNE 1 1980"));
        map.put("Stallone9", new Date("JUNE 1 1980"));
        return map;

        //напишите тут ваш код

    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //напишите тут ваш код
        ArrayList<String> key_list = new ArrayList<String>();
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<String, Date> pair = iterator.next();
            Date bd = pair.getValue();
            String key = pair.getKey();
            if (bd.getMonth() == 5 || bd.getMonth() == 6 || bd.getMonth() == 7)
                key_list.add(key);
        }

        for (int i = 0; i < key_list.size(); i++)
        {
            map.remove(key_list.get(i));
        }


    }

    public static void main(String[] args)
    {
        HashMap<String, Date> ma1 = createMap();
        removeAllSummerPeople(ma1);
        System.out.println(ma1);
    }
}
