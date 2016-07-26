package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution {
    public static HashSet<String> createSet() {
        //напишите тут ваш код
        HashSet<String> set = new HashSet<String>();
        set.add("Лимон");//1
        set.add("Любовь");//2
        set.add("Лодка");
        set.add("Ласточка");
        set.add("Ласты");
        set.add("Лондон");
        set.add("Лифт");
        set.add("Ладога");
        set.add("Ладья");
        set.add("Линза");
        set.add("Лофт");
        set.add("Ланкор");
        set.add("Латекс");
        set.add("Лида");
        set.add("Люда");
        set.add("Лапоть");
        set.add("Лев");
        set.add("Леха");
        set.add("Ленька");
        set.add("Лень");
        return set;
    }
}
