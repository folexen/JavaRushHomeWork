package com.javarush.test.level34.lesson15.big01.model;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;

import java.nio.file.Paths;

/**
 * Created by Flex on 10.03.2016.
 */
public class Model
{
    public static int FIELD_SELL_SIZE = 20;
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(Paths.get("C:\\Users\\Flex\\Downloads\\JavaRushHomeWork\\JavaRushHomeWork\\src\\com\\javarush\\test\\level34\\lesson15\\big01\\res\\levels.txt"));

    public void setEventListener(EventListener eventListener)
    {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects()
    {
        return gameObjects;
    }

    public void restartLevel(int level)
    {
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart()
    {
        restartLevel(currentLevel);
    }

    public void startNextLevel()
    {
        restartLevel(++currentLevel);
    }

    public void move(Direction direction)
    {
        Player player = getGameObjects().getPlayer();
        if (checkWallCollision(player, direction))
        {
            return;
        }
        else if (checkBoxCollision(direction))
        {
            return;
        }
        else
        {
            switch (direction)
            {
                case UP: player.move(0, -Model.FIELD_SELL_SIZE);
                    break;
                case DOWN: player.move(0, Model.FIELD_SELL_SIZE);
                    break;
                case LEFT: player.move(-Model.FIELD_SELL_SIZE, 0);
                    break;
                case RIGHT: player.move(Model.FIELD_SELL_SIZE, 0);
                    break;
            }
            checkCompletion();
        }
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction)
    {
        for (Wall wall: getGameObjects().getWalls())
        {
            if (gameObject.isCollision(wall, direction))
            {
                return true;
            }
        }
        return false;
    }

    public boolean checkBoxCollision(Direction direction)
    {
        Player player = gameObjects.getPlayer();
        GameObject stoped = null;
        for (GameObject gameObject : gameObjects.getAll())
        {
            if (!(gameObject instanceof Player) && !(gameObject instanceof Home) && player.isCollision(gameObject, direction))
            {
                stoped = gameObject;
            }
        }


        if ((stoped == null))
        {
            return false;
        }
        if (stoped instanceof Box)
        {
            Box stopedBox = (Box) stoped;
            if (checkWallCollision(stopedBox, direction))
            {
                return true;
            }
            for (Box box : gameObjects.getBoxes())
            {
                if (stopedBox.isCollision(box, direction))
                {
                    return true;
                }
            }
            switch (direction)
            {
                case LEFT:
                    stopedBox.move(-FIELD_SELL_SIZE, 0);
                    break;
                case RIGHT:
                    stopedBox.move(FIELD_SELL_SIZE, 0);
                    break;
                case UP:
                    stopedBox.move(0, -FIELD_SELL_SIZE);
                    break;
                case DOWN:
                    stopedBox.move(0, FIELD_SELL_SIZE);
            }
        }
        return false;
    }

    public void checkCompletion()
    {
        int houseCount = getGameObjects().getHomes().size();
        for (Box box: getGameObjects().getBoxes())
        {
            for (Home home: getGameObjects().getHomes())
            {
                if (box.getX() == home.getX() && box.getY() == home.getY())
                {
                    houseCount -= 1;
                }
            }
        }
        if (houseCount == 0)
        {
            eventListener.levelCompleted(currentLevel);
        }
    }


}
