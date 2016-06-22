package com.javarush.test.level31.lesson06.bonus01;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


/* Разархивируем файл
В метод main приходит список аргументов.
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002
*/
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        String resultFileName = args[0];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ArrayList<File> list = new ArrayList<>();
        for (int i = 1; i < args.length; i++)
        {
            list.add(new File(args[i]));
        }
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++)
        {
            Files.copy(list.get(i).toPath(), byteArrayOutputStream);
        }
        ZipInputStream zipInputStream = new ZipInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        FileOutputStream fileOutputStream = new FileOutputStream(resultFileName);
        ZipEntry entry = zipInputStream.getNextEntry();
        int len;
        byte[] buff = new byte[8*1024];
        if (entry!=null){
            while((len = zipInputStream.read(buff))>-1){
                fileOutputStream.write(buff, 0, len);
                fileOutputStream.flush();
            }
        }

        zipInputStream.close();
        byteArrayOutputStream.close();
        fileOutputStream.close();

    }
}





//C:\Users\Flex\Desktop\task\movie.avi C:\Users\Flex\Desktop\task\The.Missing-08.part1 C:\Users\Flex\Desktop\task\The.Missing-08.part2 C:\Users\Flex\Desktop\task\The.Missing-08.part3 C:\Users\Flex\Desktop\task\The.Missing-08.part4 C:\Users\Flex\Desktop\task\The.Missing-08.part5 C:\Users\Flex\Desktop\task\The.Missing-08.part6

