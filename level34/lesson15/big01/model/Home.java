package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by Flex on 15.03.2016.
 */
public class Home extends GameObject
{
    public Home(int x, int y)
    {
        super(x, y);
        setHeight(2);
        setWidth(2);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.RED);
        graphics.drawRect(getX(), getY(), getWidth() + Model.FIELD_SELL_SIZE/2, getHeight() + Model.FIELD_SELL_SIZE/2);
        graphics.setColor(Color.white);
        graphics.fillRect(getX() + Model.FIELD_SELL_SIZE/4, getY() + Model.FIELD_SELL_SIZE/4,
                getWidth() + Model.FIELD_SELL_SIZE/2, getHeight() + Model.FIELD_SELL_SIZE/2);
    }
}
