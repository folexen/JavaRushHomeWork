package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Flex on 22.06.2016.
 */
public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return bufferedReader.readLine();
        }

    public static List<Dish> getAllDishesForOrder() throws IOException{
        List<Dish> orderedDishes = new ArrayList<>();
        writeMessage("Please select desired dishes:");
        writeMessage(Dish.allDishesToString());
        writeMessage("After finishing the order, please type \"exit\".");
        String inputString;
        while (!(inputString = readString()).equalsIgnoreCase("exit")){
            Dish chosenDish = null;
            for (int i = 0; i < Dish.values().length; i++){
                    if (inputString.equalsIgnoreCase(Dish.values()[i].name())){
                        chosenDish = Dish.values()[i];
                        break;
                    }
            }
            if (chosenDish == null){
                writeMessage("No such dish, select another one, or exit.");
            }
            else {
                writeMessage("Meal " + chosenDish.name() + " accepted.");
                orderedDishes.add(chosenDish);
            }
        }
        return orderedDishes;
    }
}


