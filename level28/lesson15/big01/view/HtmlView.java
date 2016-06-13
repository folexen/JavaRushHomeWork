package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by Flex on 15.01.2016.
 */
public class HtmlView implements View
{
    private Controller controller;
    private final String filePath;
    {
        filePath = this.getClass().getPackage().toString().replace(".", "/").replace("package ", "./src/").concat("/vacancies.html");
    }

    @Override
    public void update(List<Vacancy> vacancies)
    {
        try
        {
            updateFile(getUpdatedFileContent(vacancies));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

    @Override
    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod()
    {
        controller.onCitySelect("Kiev");

    }

    private String getUpdatedFileContent(List<Vacancy> vacancyList) throws IOException
    {
        String updatedFileContent;

        Document document = getDocument();
        Element element = document.select("[class*=\"template\"]").first();

        Element elementCopy = element.clone();
        elementCopy.removeAttr("style");
        elementCopy.removeClass("template");

        document.select("tr[class=\"vacancy\"]").remove();

        for (Vacancy vacancy: vacancyList)
        {
            Element currentElement = elementCopy.clone();
            currentElement.select("[class*=\"city\"]").first().text(vacancy.getCity());
            currentElement.select("[class*=\"companyName\"]").first().text(vacancy.getCompanyName());
            currentElement.select("[class*=\"salary\"]").first().text(vacancy.getSalary());
            Element link = currentElement.select("a").first();
            link.text(vacancy.getTitle());
            link.attr("href", vacancy.getUrl());
            element.before(currentElement.outerHtml());
        }
        updatedFileContent = document.html();

        return updatedFileContent;
    }

    private void updateFile(String string)
    {
        try (FileOutputStream fos = new FileOutputStream(filePath))
        {
            fos.write(string.getBytes());
            fos.close();

        }
        catch (Exception ex)
        {

        }
    }

    protected Document getDocument() throws IOException
    {
        return Jsoup.parse(new File(filePath), "utf-8");
    }
}
