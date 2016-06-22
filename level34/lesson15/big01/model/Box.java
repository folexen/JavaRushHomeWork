package com.javarush.test.level34.lesson15.big01.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Flex on 10.03.2016.
 */
public class Box extends CollisionObject implements Movable
{
    public Box(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics)
    {
        /*
        Primitive graphics code. First version.
        graphics.setColor(Color.BLUE);
        graphics.drawRect(getX(), getY(), getWidth(), getHeight());
        graphics.fillRect(getX(), getY(), getWidth(), getHeight());
        */
        BufferedImage image = null;
        try
        {
            image = ImageIO.read(new File("C:\\Users\\Flex\\Downloads\\JavaRushHomeWork\\JavaRushHomeWork\\src\\com\\javarush\\test\\level34\\lesson15\\big01\\res\\BOX.jpg"));
        }
        catch (IOException ex)
        {

        }
        graphics.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);

    }

    @Override
    public void move(int x, int y)
    {
        int newX = getX();
        int newY = getY();
        setX(newX + x);
        setY(newY + y);
    }
}
