package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by Flex on 14.09.2015.
 */
public class ImageReaderFactory
{
    public static ImageReader getReader(ImageTypes imageTypes)
    {
        if (imageTypes == ImageTypes.JPG) return new JpgReader();
        else if (imageTypes == ImageTypes.PNG) return new PngReader();
        else if (imageTypes == ImageTypes.BMP) return new BmpReader();
        else throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
