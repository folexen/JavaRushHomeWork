package com.javarush.test.level08.lesson08.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution {
    public static void main(String[] args) {
        HashMap<String, String> tmp = createMap();
        removeTheFirstNameDuplicates(tmp);
        for (Map.Entry<String, String> values : tmp.entrySet()) {
            String key = values.getKey();
            String value = values.getValue();
            System.out.println(key + " " + value);
        }
    }
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("q1", "name1");
        map.put("q2", "name2");
        map.put("q3", "name3");
        map.put("q4", "name1");
        map.put("q5", "name2");
        map.put("q6", "name3");
        map.put("q7", "name4");
        map.put("q8", "name5");
        map.put("q9", "name6");
        map.put("q10", "name7");
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код
        ArrayList<String> names = new ArrayList<String>();
        for (Map.Entry<String, String> pair : map.entrySet()) {
            String n1 = pair.getValue();
            String key = pair.getKey();
            for (Map.Entry<String, String> pair2 : map.entrySet()) {
                String n2 = pair2.getValue();
                String key2 = pair2.getKey();
                if (n2.equals(n1))
                    if(!key2.equals(key)) {
                    names.add(n2);
                    }
            }
        }
        for (int i = 0; i < names.size(); i++) {
            String value = names.get(i);
            removeItemFromMapByValue(map, value);
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
