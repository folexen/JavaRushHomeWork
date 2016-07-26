package com.javarush.test.level08.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Нужно добавить в программу новую функциональность
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи

Лондон

Пример вывода:
Абрамовичи
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //list of addresses
        HashMap<String, String> ad_map = new HashMap<String, String>();
        while (true) {
            String town = reader.readLine();
            if (town.isEmpty()) break;
            String family = reader.readLine();
            if (family.isEmpty()) break;
            ad_map.put(town, family);
        }
        //Town input
        String tmp = reader.readLine().toUpperCase();
        for (Map.Entry<String, String> pair : ad_map.entrySet()) {
            String town_get = pair.getKey();
            if (town_get.toUpperCase().equals(tmp))
                System.out.println(pair.getValue());
        }
    }
}
