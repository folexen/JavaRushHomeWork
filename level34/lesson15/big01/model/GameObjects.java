package com.javarush.test.level34.lesson15.big01.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Flex on 15.03.2016.
 */
public class GameObjects
{
    private Set<Wall> walls;
    private Set<Box> boxes;
    private Set<Home> homes;
    private Player player;

    public GameObjects(Set<Wall> walls, Set<Box> boxes, Set<Home> homes, Player player)
    {
        this.walls = walls;
        this.boxes = boxes;
        this.homes = homes;
        this.player = player;
    }

    public Set<Wall> getWalls()
    {
        return walls;
    }

    public void setWalls(Set<Wall> walls)
    {
        this.walls = walls;
    }

    public Set<Box> getBoxes()
    {
        return boxes;
    }

    public void setBoxes(Set<Box> boxes)
    {
        this.boxes = boxes;
    }

    public Set<Home> getHomes()
    {
        return homes;
    }

    public void setHomes(Set<Home> homes)
    {
        this.homes = homes;
    }

    public Player getPlayer()
    {
        return player;
    }

    public void setPlayer(Player player)
    {
        this.player = player;
    }

    public Set<GameObject> getAll()
    {
        Set<GameObject> gameObjectSet = new HashSet<>();
        gameObjectSet.addAll(getBoxes());
        gameObjectSet.addAll(getHomes());
        gameObjectSet.addAll(getWalls());
        gameObjectSet.add(getPlayer());
        return gameObjectSet;
    }
}
