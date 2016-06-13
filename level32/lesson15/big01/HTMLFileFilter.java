package com.javarush.test.level32.lesson15.big01;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by Flex on 18.02.2016.
 */
public class HTMLFileFilter extends FileFilter
{
    @Override
    public boolean accept(File file)
    {
        String fileName = file.getName().toLowerCase();
        return fileName.endsWith(".html") || fileName.endsWith(".htm") || file.isDirectory();
    }

    @Override
    public String getDescription()
    {
        return "HTML и HTM файлы";
    }
}
