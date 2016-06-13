package com.javarush.test.level31.lesson06.home01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Path zipFile = Paths.get(args[1]);
        Path fileToCopy = Paths.get(args[0]);
        Path tempFile = Files.createTempFile(null, null);
        boolean fileExists = false;
        try(ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile));
            InputStream inputStream = Files.newInputStream(fileToCopy);
            OutputStream outputStream = Files.newOutputStream(tempFile);
            ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream))
            {
                ZipEntry zipEntry = zipInputStream.getNextEntry();
                byte[] bytes = new byte[1024];
                while (zipEntry != null)
                {
                    if (zipEntry.getName().equals(fileToCopy.getFileName().toString()))
                    {
                        fileExists = true;
                        zipEntry = zipInputStream.getNextEntry();
                    }
                    else
                    {
                        zipOutputStream.putNextEntry(zipEntry);
                        int data;
                        while ((data = zipInputStream.read(bytes)) > 0)
                        {
                            zipOutputStream.write(bytes, 0, data);
                        }
                        zipInputStream.closeEntry();
                        zipEntry = zipInputStream.getNextEntry();
                    }

                }
                if (fileExists)
                {
                    String newFile = "new\\" + fileToCopy.getFileName().toString();

                    ZipEntry newZipEntryFolder = new ZipEntry(newFile);
                    zipOutputStream.putNextEntry(newZipEntryFolder);

                    while (inputStream.available() > 0)
                    {
                        int dataX = inputStream.read(bytes);
                        zipOutputStream.write(bytes, 0, dataX);
                    }
                    zipOutputStream.closeEntry();
                }
            }
        Files.move(tempFile, zipFile, StandardCopyOption.REPLACE_EXISTING);
    }
}
