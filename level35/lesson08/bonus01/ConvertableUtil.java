package com.javarush.test.level35.lesson08.bonus01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static Map convert(List<? extends Convertable> list) {
        Map<? super Object,? super Convertable> result = new HashMap();
        for (Convertable listObject: list)
        {
            result.put(listObject.getKey(), listObject);
        }
        return result;
    }
}
