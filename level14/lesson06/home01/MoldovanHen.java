package com.javarush.test.level14.lesson06.home01;

public class MoldovanHen extends Hen implements Country {
    public int getCountOfEggsPerMonth() {
        return 32;
    }

    public String getDescription() {
        String s = super.getDescription() + " Моя страна - " + MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
        return s;
    }
}