package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException
    {
        List<String> resultFileList = new ArrayList<>();
        List<File> directoryToProcessList = new ArrayList<>();
        List<File> directoryTemporaryStorage = new ArrayList<>();
        List<File> directoryToRemoveList = new ArrayList<>();
        File file = new File(root);
        directoryToProcessList.add(file);
        while (directoryToProcessList.size()>0)
        {
            for (File fileToCheck: directoryToProcessList)
            {
                for (File fileInDirectoryToProcess: fileToCheck.listFiles())
                {
                    if (fileInDirectoryToProcess.isDirectory())
                    {
                        directoryTemporaryStorage.add(fileInDirectoryToProcess);
                    }
                    else
                    {
                        resultFileList.add(fileInDirectoryToProcess.getAbsolutePath());
                    }
                }
                directoryToRemoveList.add(fileToCheck);
            }
            directoryToProcessList.removeAll(directoryToRemoveList);
            directoryToRemoveList.clear();
            directoryToProcessList.addAll(directoryTemporaryStorage);
            directoryTemporaryStorage.clear();
        }
        return resultFileList;
    }

    public static void main(String[] args)
    {
        List<String> list = null;
        try
        {
            list = getFileTree("C:\\Users\\Flex\\Desktop\\папка главная\\");
        }
        catch (IOException ex)
        {
            System.out.println("IOException caught.");
            ex.printStackTrace();
        }
        for (String str : list)
        {
            System.out.println(str);
        }

    }
}
