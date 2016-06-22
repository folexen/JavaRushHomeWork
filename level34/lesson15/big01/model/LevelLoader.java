package com.javarush.test.level34.lesson15.big01.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Flex on 15.03.2016.
 */
public class LevelLoader
{
    private Path levels;

    public LevelLoader(Path levels)
    {
        this.levels = levels;
    }

    public GameObjects getLevel(int level)
    {
        if (level > 60)
        {
            level -= 60;
        }
        Set<Wall> walls = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Player player = new Player(Model.FIELD_SELL_SIZE / 2, Model.FIELD_SELL_SIZE / 2);
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new FileReader(levels.toString()));
            String s = "";
            while(true) {
                if (reader.readLine().equals("Maze: " + level)) break;
            }
            reader.readLine();
            int x = Integer.parseInt(reader.readLine().split(" ")[2]);
            int y = Integer.parseInt(reader.readLine().split(" ")[2]);
            int size = Model.FIELD_SELL_SIZE;
            for (int i = 0; i < 3; i++) reader.readLine();
            for (int i = 0; i < y; i++) {
                s = reader.readLine();
                for (int j = 0; j < x; j++) {
                    switch (s.charAt(j)) {
                        case 'X' : walls.add(new Wall(j * size + size / 2, i * size + size / 2));
                            break;
                        case '*' : boxes.add(new Box(j * size + size / 2, i * size + size / 2));
                            break;
                        case '.' : homes.add(new Home(j * size + size / 2, i * size + size / 2));
                            break;
                        case '&' : boxes.add(new Box(j * size + size / 2, i * size + size / 2));
                            homes.add(new Home(j * size + size / 2, i * size + size / 2));
                            break;
                        case '@' : player = new Player(j * size + size / 2, i * size + size / 2);
                            break;
                    }
                }
            }
            reader.close();
        }
        catch (IOException e) {
        }
        GameObjects objects = new GameObjects(walls, boxes, homes, player);
        return objects;
    }
}

