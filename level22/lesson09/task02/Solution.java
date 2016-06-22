package com.javarush.test.level22.lesson09.task02;

import java.util.LinkedHashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {
    public static void main(String[] args)
    {
        Map<String, String> params = new LinkedHashMap<>();
        params.put("name", "Ivanov");
        params.put("country", "Ukraine");
        params.put("city", "Kiev");
        params.put("age", null);
        params.put("Height", "181 cm");
        System.out.println(getCondition(params));

    }

    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        if (params == null || params.size() == 0) return sb;
        for (Map.Entry<String, String> pair : params.entrySet())
        {
            if (pair.getValue() != null)
            {
                sb = sb.append(String.format("%s = \'%s\' and ", pair.getKey(), pair.getValue()));
            }
        }
        sb = sb.delete(sb.lastIndexOf(" and"), sb.length());
        return sb;
    }
}
