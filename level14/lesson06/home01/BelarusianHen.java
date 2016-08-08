package com.javarush.test.level14.lesson06.home01;

public class BelarusianHen extends Hen implements Country {
    public int getCountOfEggsPerMonth() {
        return 47;
    }

    public String getDescription() {
        String s = super.getDescription() + " Моя страна - " + BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
        return (s);
    }
}

