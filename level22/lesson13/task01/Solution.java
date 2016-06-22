package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static void main(String[] args)
    {
        for (String s : getTokens("level22.lesson13.task01", "."))
        {
            System.out.println(s);
        }

    }
    public static String [] getTokens(String query, String delimiter) {
        ArrayList<String> res = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        while (tokenizer.hasMoreTokens())
        {
            String element = tokenizer.nextToken();
            res.add(element);
        }
        String[] result = new String[res.size()];
        result = res.toArray(result);
        return result;
    }
}
