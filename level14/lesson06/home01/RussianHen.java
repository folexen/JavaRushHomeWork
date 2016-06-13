package com.javarush.test.level14.lesson06.home01;

public class RussianHen extends Hen implements Country
{
    public int getCountOfEggsPerMonth()
    {
        return 25;
    }
    public String getDescription()
    {
        String s = super.getDescription() + " Моя страна - " + RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
        return s;
    }

}