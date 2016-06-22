package com.javarush.test.level14.lesson06.home01;

public class UkrainianHen extends Hen implements Country
{
    public int getCountOfEggsPerMonth()
    {
        return 21;
    }
    public String getDescription()
    {
        String s = super.getDescription() + " Моя страна - " + UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
        return s;
    }

}
