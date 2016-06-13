package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        ArrayList<Human> child =  new ArrayList<Human>(); //Children list
        ArrayList<Human> grandchild =  new ArrayList<Human>(); //Children list
        ArrayList<Human> grandparents =  new ArrayList<Human>(); //Children list
        //Children creation
        Human child1 = new Human ("Child", false, 10);
        Human child2 = new Human ("Child2", false, 6);
        Human child3 = new Human ("Child3", true, 3);
        //Children add to list
        child.add(child1);
        child.add(child2);
        child.add(child3);
        //Parent creation
        Human mom = new Human("Mom", false, 32, child);
        Human dad = new Human("Dad", true, 32, child);
        //Parents addition to children list
        grandchild.add(mom);
        grandchild.add(dad);
        //Grandparents creation
        Human granny1 = new Human("Granny1", false, 55, grandchild);
        Human granny2 = new Human("Granny2", false, 53, grandchild);
        Human granpa1 = new Human("Grannpa1", true, 59, grandchild);
        Human granpa2 = new Human("Granpa2", true, 58, grandchild);
        //Grandparents addition to Arrylist
        grandparents.add(granny1);
        grandparents.add(granny2);
        grandparents.add(granpa1);
        grandparents.add(granpa2);
        for (Human text : child){
            System.out.println(text);
        }for (Human text : grandchild){
            System.out.println(text);
        }for (Human text : grandparents){
            System.out.println(text);
        }
    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        Boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>();

        public Human(String name, Boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }public Human(String name, Boolean sex, int age, ArrayList<Human> children)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
