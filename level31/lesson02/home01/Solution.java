package com.javarush.test.level31.lesson02.home01;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution {

    public static void main(String[] args) {
        //Список листов для работы.
        List<File> listOfFiles = new ArrayList<>();
        List<File> directoryToProcessList = new ArrayList<>();
        List<File> directoryTemporaryStorage = new ArrayList<>();
        List<File> directoryToRemoveList = new ArrayList<>();
        List<File> filesToRemove = new ArrayList<>();
        //инициализация путей.
        String path = args[0];
        String resultAbsolutePath = args[1];
        //создание файла
        File file = new File(path);
        File resultFile = new File(resultAbsolutePath);
        File renamedFile = new File(resultFile.getParentFile() + "/allFilesContent.txt");
        if (renamedFile.exists())
        {
            renamedFile.delete();
        }
        //добавления корневого каталога в лист для процессинга
        directoryToProcessList.add(file);
        //обработка листа для процессинга
        while (directoryToProcessList.size()>0)
        {
            //цикличная проверка списка файлов.
            for (File fileToCheck: directoryToProcessList)
            {
                for (File fileInDirectoryToProcess: fileToCheck.listFiles()) //получаем список файлов в директории
                {
                    if(fileInDirectoryToProcess.equals(resultFile))return;
                    if (fileInDirectoryToProcess.isDirectory())
                    {
                        if (!(fileInDirectoryToProcess.listFiles().length == 0))
                        {
                            directoryTemporaryStorage.add(fileInDirectoryToProcess);//обрабатываем НЕпустые директории
                        }
                        else
                        {
                            filesToRemove.add(fileInDirectoryToProcess);//пустые диеркотрии добавляем в список для удаления
                        }
                    }
                    else
                    {
                        if (!(fileInDirectoryToProcess.length() > 50)) //обрабатываем файл с размером НЕ более 50 байт
                        {
                            listOfFiles.add(fileInDirectoryToProcess); // добавляем его в результирующий список для последующей обработки
                        }
                        else
                        {
                            filesToRemove.add(fileInDirectoryToProcess); //добавляем файл с размером больше 50 байт в список для удаления
                        }
                    }
                }
                directoryToRemoveList.add(fileToCheck);
            }
            directoryToProcessList.removeAll(directoryToRemoveList);
            directoryToRemoveList.clear();
            directoryToProcessList.addAll(directoryTemporaryStorage);
            directoryTemporaryStorage.clear();
        }

        //сортировка файлов по имени
        Collections.sort(listOfFiles);

        //удаление пустых директорий
        for (File emptyDirectory: filesToRemove)
        {
            emptyDirectory.delete();
        }

        //запись тела файла в результирующий файл.
        try (FileOutputStream fos = new FileOutputStream(resultFile, true))
        {
            for (File file1: listOfFiles)
            {
                try(FileInputStream fis = new FileInputStream(file1))
                {
                    while (fis.available() > 0)
                    {
                        fos.write(fis.read());
                    }
                }
                catch (Exception ex1)
                {

                }
                fos.write('\n');

            }
        }
        catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch (IOException ex1)
        {
            ex1.printStackTrace();
        }
        //переимнование резултирующего файла
        boolean rsl = resultFile.renameTo(renamedFile);

    }
}
