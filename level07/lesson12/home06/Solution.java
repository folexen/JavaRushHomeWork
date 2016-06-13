package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human gpa1 = new Human("Stan", true, 55);
        Human gpa2 = new Human("Bill", true, 55);
        Human gma1 = new Human("Linda", false, 55);
        Human gma2 = new Human("Mandy", false, 55);
        Human mother = new Human ("Lisa", false, 37, gpa1, gma1);
        Human father = new Human ("Kyle", true, 39, gpa2, gma2);
        Human child = new Human ("Kate", false, 18, father, mother);
        Human child1 = new Human ("Leo", true, 19, father, mother);
        Human child2 = new Human ("Kira", false, 11, father, mother);
        System.out.println(gpa1);
        System.out.println(gpa2);
        System.out.println(gma1);
        System.out.println(gma2);
        System.out.println(mother);
        System.out.println(father);
        System.out.println(child);
        System.out.println(child1);
        System.out.println(child2);




    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        public Human(String name, boolean sex, int age, Human father, Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
