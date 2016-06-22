package com.javarush.test.level36.lesson04.home01;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Flex on 30.03.2016.
 */
public class Service
{
    public List<String> getData() {
    java.util.List<java.lang.String> data = new ArrayList<java.lang.String>() {{
        add("First string");
        add("Second string");
        add("Third string");
    }};
    return data;
}
}
