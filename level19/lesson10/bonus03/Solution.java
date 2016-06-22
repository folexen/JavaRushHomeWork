package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String filename = br.readLine();
        br.close();
        BufferedReader filereader = new BufferedReader(new FileReader(filename));
        String start_tag = "<".concat(args[0]);
        String end_tag = "</".concat(args[0]).concat(">");
        StringBuilder sb = new StringBuilder();
        while (filereader.ready())
        {
            sb = sb.append(filereader.readLine());
        }
        filereader.close();
        int s = sb.toString().indexOf(start_tag);
        int e = sb.toString().lastIndexOf(end_tag);
        StringBuilder result = new StringBuilder(sb);
        String work_string = result.toString();
        int[] start = new int[10];
        int[] end = new int[10];
        int count = 0;
        int span_count = 0;
        for (int i = 0; i < work_string.length(); i++)
        {
            if (work_string.charAt(i) == '<')
            {
                if (TrueStart(result.substring(i, i + start_tag.length()), start_tag) == true)
                {
                    start[count] = i;
                    count++;
                    span_count++;
                }
            }
            if (work_string.charAt(i) == '<')
            {
                if (TrueEnd(result.substring(i, i + end_tag.length()), end_tag) == true)
                {
                    count--;
                    end[count] = i+end_tag.length();
                }
            }
            if (count == 0)
            {
                for (int k = 0; k < span_count; k++)
                {
                    System.out.println(result.substring(start[k], end[k]));
                }
                span_count=0;

            }
        }
    }
    public static boolean TrueStart(String string, String start_tag)
    {
        int count = 0;
        for (int i = 0; i < start_tag.length(); i++)
        {
          if (string.charAt(i) == start_tag.charAt(i)) count++;
        }
        if (count == start_tag.length()) return true;
        else return false;
    }
    public static boolean TrueEnd(String string, String end_tag)
    {
        int count = 0;
        for (int i = 0; i < end_tag.length(); i++)
        {
          if (string.charAt(i) == end_tag.charAt(i)) count++;
        }
        if (count == end_tag.length()) return true;
        else return false;
    }

}

