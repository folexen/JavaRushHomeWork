package com.javarush.test.level32.lesson15.big01.listeners;

import com.javarush.test.level32.lesson15.big01.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

/**
 * Created by Flex on 17.02.2016.
 */
public class TextEditMenuListener implements MenuListener
{
    private View view;

    public TextEditMenuListener(View view)
    {
        this.view = view;
    }

    @Override
    public void menuSelected(MenuEvent menuEvent)
    {
       JMenu jMenu = (JMenu) menuEvent.getSource();
        for (Component jMenus: jMenu.getMenuComponents())
        {
            jMenus.setEnabled(view.isHtmlTabSelected());
        }
    }

    @Override
    public void menuDeselected(MenuEvent menuEvent)
    {

    }

    @Override
    public void menuCanceled(MenuEvent menuEvent)
    {

    }
}
