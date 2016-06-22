package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static sun.plugin.javascript.navig.JSType.Document;

/**
 * Created by Flex on 14.01.2016.
 */
public class HHStrategy implements Strategy
{
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        List<Vacancy> vacancyList = new ArrayList<>();
        Document document = null;
        int i = 0;
        while (i<1)
        {
            try {
                document = getDocument(searchString,i++);
            } catch (IOException e) {
            }
            Elements all = document.select("[data-qa=\"vacancy-serp__vacancy\"]");
            if (all.size() > 0) {
                for (Element e : all) {
                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(e.select("[data-qa=\"vacancy-serp__vacancy-title\"]").text());
                    vacancy.setCompanyName(e.select("[data-qa=\"vacancy-serp__vacancy-employer\"]").text());
                    vacancy.setCity(e.select("[data-qa=\"vacancy-serp__vacancy-address\"]").text());
                    vacancy.setSiteName("http://hh.ua/");
                    vacancy.setUrl(e.select("[data-qa=\"vacancy-serp__vacancy-title\"]").attr("href"));
                    vacancy.setSalary(e.select("[data-qa=\"vacancy-serp__vacancy-compensation\"]").text());
                    vacancyList.add(vacancy);
                }
            } else {
                break;
            }
        }
        return vacancyList;
    }
    protected Document getDocument(String searchString, int page) throws IOException
    {
        String url = String.format(URL_FORMAT, searchString, page);
        return Jsoup.connect(url)
                .referrer("https://www.google.com.ua")
                .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0")
                .get();

    }
}
