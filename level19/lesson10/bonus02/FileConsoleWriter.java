package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.*;

public class FileConsoleWriter extends FileWriter
{
    public static void main(String[] args)throws IOException
    {
        FileConsoleWriter fcw = new FileConsoleWriter("C:\\Users\\Flex\\Desktop\\1.txt");
        fcw.write("Howdy partner");
        fcw.write("Test char array".toCharArray());
        fcw.write("Test char array".toCharArray(), 2, 9);
        fcw.write(1);
        fcw.write("Test string", 2, 9);
        fcw.close();
    }


    public FileConsoleWriter(String s) throws IOException
    {
        super(s);
    }

    public FileConsoleWriter(String s, boolean b) throws IOException
    {
        super(s, b);
    }

    public FileConsoleWriter(File file) throws IOException
    {
        super(file);
    }

    public FileConsoleWriter(File file, boolean b) throws IOException
    {
        super(file, b);
    }

    public FileConsoleWriter(FileDescriptor fileDescriptor)
    {
        super(fileDescriptor);
    }

    @Override
    public void write(int i) throws IOException
    {
        super.write(i);
        System.out.print(Character.toChars(i));
    }

    @Override
    public void write(char[] chars, int i, int i1) throws IOException
    {
        super.write(chars, i, i1);
        System.out.print(String.valueOf(chars).substring(i, i+i1));
    }

    @Override
    public void write(String s, int i, int i1) throws IOException
    {
        super.write(s, i, i1);
        System.out.print(s.substring(i, i1));
    }
}
