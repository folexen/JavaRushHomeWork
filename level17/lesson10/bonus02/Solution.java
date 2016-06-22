package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static synchronized void main(String[] args) throws ParseException{
        //start here - начни тут
        Person person = null;
        String name = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        //-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
        if (args[0].equals("-c"))
        {
            int name_ind = 1;
            for (int i = 1; i < args.length-1; i++)
            {
                if (args[i].equals("м") || args[i].equals("ж"))
                {
                    for (int j = name_ind; j < i; j++)
                    {
                        name += args[j] + " ";
                    }
                    name = name.trim();
                    if (args[i].equals("м"))
                    {
                        allPeople.add(Person.createMale(name, sdf.parse(args[i+1])));
                    }
                    if (args[i].equals("ж"))
                    {
                        allPeople.add(Person.createFemale(name, sdf.parse(args[i+1])));
                    }
                    System.out.println(allPeople.size() - 1);
                    name_ind = i+2;
                    name = "";
                }
            }
        }
        //-u  - обновляет соответствующие данные людей с заданными id
        if (args[0].equals("-u"))
        {
            int name_ind = 2;
            for (int i = 1; i < args.length-1; i++)
            {
                if (args[i].equals("м") || args[i].equals("ж"))
                {
                    for (int j = name_ind; j < i; j++)
                    {
                        name += args[j] + " ";
                    }
                    name = name.trim();
                    person = allPeople.get(Integer.parseInt(args[name_ind - 1]));
                    person.setName(name);
                    person.setBirthDay(sdf.parse(args[i+1]));
                    if (args[i].equals("м"))
                    {
                        person.setSex(Sex.MALE);
                    }
                    if (args[i].equals("ж"))
                    {
                        person.setSex(Sex.FEMALE);
                    }
                    name_ind = i + 3;
                    name = "";
                }
            }
        }
        //-d  - производит логическое удаление всех людей с заданными id
        if (args[0].equals("-d"))
        {
            for (int i = 1; i < args.length; i++)
            {
                person = allPeople.get(Integer.parseInt(args[i]));
                person.setName(null);
                person.setBirthDay(null);
                person.setSex(null);
            }
        }
        //-i  - выводит на экран информацию о всех людях с заданными id: name sex bd
        if (args[0].equals("-i"))
        {
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            for (int i = 1; i < args.length; i++)
            {
                String sex = "";
                person = allPeople.get(Integer.parseInt(args[i]));
                if (person.getSex().equals(Sex.MALE)) {sex = "м";}
                if (person.getSex().equals(Sex.FEMALE)) {sex = "ж";}
                System.out.println(person.getName() + " " + sex + " " + sdf2.format(person.getBirthDay()));
            }
        }
    }
}
