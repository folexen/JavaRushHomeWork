package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Flex on 29.06.2016.
 */
public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException
    {
        if (storage.list().isEmpty()) {
            throw new NoVideoAvailableException();
        }
        List<Advertisement> sortedVideos = storage.list();
        Collections.sort(sortedVideos, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                if (o1.getAmountPerOneDisplaying() != o2.getAmountPerOneDisplaying())
                    return Long.compare(o2.getAmountPerOneDisplaying(), o1.getAmountPerOneDisplaying());
                if (o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration() != o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration())
                    return Long.compare(o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration(), o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration());
                return 0;
            }
        });
        int timeLeft = timeSeconds;
        for (Advertisement advertisement : sortedVideos) {
            if (timeLeft >= advertisement.getDuration()) {
                ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d", advertisement.getName(),
                        advertisement.getAmountPerOneDisplaying(),
                        (advertisement.getAmountPerOneDisplaying() * 1000)/ advertisement.getDuration()));
                timeLeft -= advertisement.getDuration();
                try
                {
                    advertisement.revalidate();
                }
                catch (UnsupportedOperationException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
    }
}
