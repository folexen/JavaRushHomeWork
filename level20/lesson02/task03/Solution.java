package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception
    {
        //implement this method - реализуйте этот метод
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String file = r.readLine();
        BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));
        load(fis);
        fis.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties p_map = new Properties();
        for (Map.Entry<String, String> pair : properties.entrySet())
        {
            String key = pair.getKey();
            String value = pair.getValue();
            p_map.setProperty(key, value);
        }
        p_map.store(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties p_map = new Properties();
        p_map.load(inputStream);
        Set<String> key = p_map.stringPropertyNames();
        properties.clear();
        for (String text: key)
        {
            properties.put(text, p_map.getProperty(text));
        }
    }

    public static void main(String[] args) throws Exception
    {
        Solution sol = new Solution();
        sol.fillInPropertiesMap();
        for (Map.Entry<String, String> pair : properties.entrySet())
        {
            System.out.println(pair.getKey() + pair.getValue());
        }
        sol.save(new FileOutputStream("C:\\Users\\Flex\\Desktop\\1.txt"));
    }
}
