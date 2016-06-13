package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Flex on 20.10.2015.
 */
public class Hippodrome
{
    private static ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public static void main(String[] args) throws InterruptedException
    {
        game = new Hippodrome();
        game.horses.add(new Horse("Horse1", 3, 0));
        game.horses.add(new Horse("Horse2", 3, 0));
        game.horses.add(new Horse("Horse3", 3, 0));
        game.getHorses();

        game.run();
        game.printWinner();
    }
    public ArrayList<Horse> getHorses()
    {
        return horses;
    }
    public void move()
    {
        for (Horse h : horses)
        {
            h.move();
        }

    }
    public void run() throws InterruptedException
    {
        for (int i = 0; i < 100; i++)
        {
            move();
            print();
            Thread.sleep(200);
        }

    }
    public void print()
    {
        for (Horse h : horses)
        {
            h.print();
        }
        System.out.println();
        System.out.println();
    }
    public Horse getWinner()
    {
        double max = 0;
        Horse winner = new Horse("Zero", 0, 0);
        for (Horse h : horses)
        {
            if( h.getDistance() > max)
            {
                max = h.getDistance();
                winner = h;
            }
        }
        return winner;
    }
    public void printWinner()
    {
        System.out.println("Winner is "+ getWinner().getName() + "!");
    }

}
