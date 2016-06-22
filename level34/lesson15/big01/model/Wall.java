package com.javarush.test.level34.lesson15.big01.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Flex on 15.03.2016.
 */
public class Wall extends CollisionObject
{

    public Wall(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics)
    {
        /*graphics.setColor(Color.orange);
        graphics.drawRect(getX(), getY(), getWidth(), getHeight());
        graphics.fillRect(getX() + 1, getY() + 1, getWidth() - 2, getHeight() - 2);*/

        BufferedImage image = null;

        try
        {
            image = ImageIO.read(new File("C:\\Users\\Flex\\Downloads\\JavaRushHomeWork\\JavaRushHomeWork\\src\\com\\javarush\\test\\level34\\lesson15\\big01\\res\\WALL.jpg"));
        }
        catch (IOException ex)
        {

        }
        graphics.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);

    }
}
