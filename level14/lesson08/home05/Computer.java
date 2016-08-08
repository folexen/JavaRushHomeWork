package com.javarush.test.level14.lesson08.home05;

/**
 * Created by Flex on 02.09.2015.
 */
public class Computer {
    private Mouse mouse = new Mouse();
    private Keyboard keyboard = new Keyboard();
    private Monitor monitor = new Monitor();

    public Mouse getMouse() {
        return mouse;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public Computer() {
    }
}
