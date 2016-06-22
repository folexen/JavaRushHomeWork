package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename=reader.readLine();
        while(!filename.equals("exit")){
            new ReadThread(filename).start();
            filename=reader.readLine();
        }
        reader.close();
    }
    public static class ReadThread extends Thread  {
        String fileName = new String();
        public ReadThread(String fileName) {
            this.fileName = fileName;
        }
        @Override
        public void run() {
            try{
                FileInputStream inputStream = new FileInputStream(fileName);
                List<Integer> list = new ArrayList<Integer>();
                while (inputStream.available()>0){
                    list.add(inputStream.read());
                }
                Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                for (int i=0; i < list.size(); i++){
                    Integer amount = 1;
                    for (int j=i+1; j<list.size();){
                        if (list.get(i).equals(list.get(j))){
                            list.remove(j);
                            amount++;
                        }
                        else j++;
                    }
                    map.put(list.get(i), amount);
                }
                int maxValue = 0;
                for(Map.Entry<Integer, Integer> pair : map.entrySet())
                {
                    Integer value = pair.getValue();
                    if (value > maxValue)
                    {
                        maxValue = value;
                    }
                }
                for(Map.Entry<Integer, Integer> pair : map.entrySet())
                {
                    Integer key = pair.getKey();
                    Integer value = pair.getValue();
                    if (value == maxValue)
                    {
                        resultMap.put(fileName, key);
                    }
                }
                inputStream.close();
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }
}

