package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter
{
    private FileOutputStream FOS;
    public AdapterFileOutputStream(FileOutputStream FOS)
    {
        this.FOS = FOS;
    }
    public void flush() throws IOException
    {
        this.FOS.flush();
    }
    public void writeString(String s) throws IOException
    {
        this.FOS.write(s.getBytes());
    }
    public void close() throws IOException
    {
        this.FOS.close();
    }
}
