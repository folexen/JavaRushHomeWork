package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Flex on 22.06.2016.
 */
public class Order {
    List<Dish> dishes;
    Tablet tablet;

    public Order(Tablet tablet) throws IOException{
        this.dishes = ConsoleHelper.getAllDishesForOrder();
        this.tablet = tablet;
    }

    @Override
    public String toString()
    {
        return "Your order: " + dishes +
                " of Tablet{number=" + tablet.number + "}";
    }
}
