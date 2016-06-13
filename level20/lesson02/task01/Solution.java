package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            File your_file_name = File.createTempFile("C:\\Users\\Flex\\Desktop\\tmp1.txt", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            if (null != name && !name.isEmpty())
            {
                outputStream.write(name.getBytes());
                outputStream.write("\r\n".getBytes());
            }else return;
            String isAssetsPresent = assets.isEmpty()?  "no": "yes";
            outputStream.write(String.valueOf(isAssetsPresent).getBytes());
            outputStream.write("\r\n".getBytes());
            if (isAssetsPresent.equals("yes"))
            {
                outputStream.write(String.valueOf(assets.size()).getBytes());
                outputStream.write("\r\n".getBytes());
                for (Asset asset : assets)
                {
                    outputStream.write(asset.getName().getBytes());
                    outputStream.write("\r\n".getBytes());
                    outputStream.write(String.valueOf(asset.getPrice()).getBytes());
                    outputStream.write("\r\n".getBytes());
                }
            }
        }


        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            while (inputStream.available() > 0)
            {
                this.name = readLine(inputStream);
                String isAssetsPresent = "";
                isAssetsPresent = readLine(inputStream);
                if(isAssetsPresent.equals("yes"))
                {
                    String s = "";
                    int size = Integer.parseInt(readLine(inputStream));
                    for (int i = 0; i < size; i++)
                    {
                        s = readLine(inputStream);
                        Asset as = new Asset(s);
                        try
                        {
                            as.setPrice(Double.parseDouble(readLine(inputStream)));
                        }
                        catch (Exception e)
                        {
                        }
                        this.assets.add(as);
                    }
                    return;
                }
                else if(isAssetsPresent.equals("no")){
                    return;
                }
            }
        }
        public String readLine(InputStream inputStream){
            String s ="";
            try
            {
                while (inputStream.available()>0){
                    char tmp = (char)inputStream.read();
                    if (tmp == '\r'){
                        tmp = (char)inputStream.read();
                        if (tmp == '\n'){
                            break;
                        }
                    }
                    s+=tmp;
                }
            }
            catch (IOException e)
            {
                return null;
            }
            return s;
        }
    }
}