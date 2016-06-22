package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        String name;
        int age;
        boolean sex;
        double weight;
        Object adress;
        Object job;
        //Cons1
        public Human (String name)
        {
            this.name = name;
        }
        //Cons2
        public Human (String name, int age)
        {
            this.name = name;
            this.age = age;
        }
        //Cons3
        public Human (String name, int age, boolean sex)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }
        //Cons4
        public Human (String name, boolean sex, double weight)
        {
            this.name = name;
            this.sex = sex;
            this.weight = weight;
        }
        //Cons5
        public Human (String name, int age, double weight, boolean sex)
        {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.sex = sex;
        }
        //Cons6
        public Human (String name, int age, Object adress)
        {
            this.name = name;
            this.age = age;
            this.adress = adress;
        }
        //Cons7
        public Human(String name, int age, Object adress, Object job)
        {
            this.name = name;
            this.age = age;
            this.adress = adress;
            this.job = job;
        }
        //Cons8
        public Human(String name, int age, boolean sex, Object adress, Object job)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.adress = adress;
            this.job = job;
        }
        //Cons
        public Human(String name, int age, boolean sex, double weight, Object adress)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.adress = adress;
            this.weight = weight;
        }
        //Cons10
        public Human(String name, int age, boolean sex, double weight, Object adress, Object job)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.weight = weight;
            this.adress = adress;
            this.job = job;
        }



        //напишите тут ваши переменные и конструкторы
    }
}
