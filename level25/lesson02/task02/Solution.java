package com.javarush.test.level25.lesson02.task02;

import java.util.*;

/* Машину на СТО не повезем!
Инициализируйте поле wheels используя данные из loadWheelNamesFromDB.
Обработайте некорректные данные.
Подсказка: если что-то не то с колесами, то это не машина!
Сигнатуры не менять.
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels here
            try
            {
                if  (loadWheelNamesFromDB().length != 4) throw new IllegalArgumentException();
                wheels = new ArrayList<>();
                Wheel[] list = Wheel.values();

                for (int i = 0; i < loadWheelNamesFromDB().length; i++)
                {
                    for (int j = 0; j < list.length; j++)
                    {
                        if (list[j].toString().equals(loadWheelNamesFromDB()[i]))
                        {
                            if (wheels.contains(list[j])) {throw new IllegalArgumentException();}
                            else {wheels.add(list[j]);}
                        }
                        //else throw new IllegalArgumentException();
                    }
                }
                if (wheels.size() !=4) throw  new IllegalArgumentException();
            }
            catch (IllegalArgumentException ex)
            {
                System.out.println("Это не машина");
            }

        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"BACK_LEFT", "FRONT_RIGHT", "BACK_RIGHT", "FRONT_LEFT"};
        }
    }
    public static void main(String[] args)
    {
        Car car = new Car();
        System.out.println(car.wheels);
    }
}
