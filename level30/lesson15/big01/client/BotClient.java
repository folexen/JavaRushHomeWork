package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * Created by Flex on 11.01.2016.
 */
public class BotClient extends Client
{
    @Override
    protected SocketThread getSocketThread()
    {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSentTextFromConsole()
    {
        return false;
    }

    @Override
    protected String getUserName()
    {
        String botName = "date_bot_" + (int) (Math.random()*100);
        return botName;
    }

    public static void main(String[] args)
    {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    public class BotSocketThread extends SocketThread
    {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message)
        {
            super.processIncomingMessage(message);
            String[] str = message.split(": ");
            if (str.length >= 2)
            {
                switch (str[1])
                {
                    case "дата":
                        sendTextMessage(String.format("Информация для %s: %s", str[0], new SimpleDateFormat("d.MM.YYYY").format(Calendar.getInstance().getTime())));
                        break;
                    case "день":
                        sendTextMessage(String.format("Информация для %s: %s", str[0], new SimpleDateFormat("d").format(Calendar.getInstance().getTime())));
                        break;
                    case "месяц":
                        sendTextMessage(String.format("Информация для %s: %s", str[0], new SimpleDateFormat("MMMM").format(Calendar.getInstance().getTime())));
                        break;
                    case "год":
                        sendTextMessage(String.format("Информация для %s: %s", str[0], new SimpleDateFormat("YYYY").format(Calendar.getInstance().getTime())));
                        break;
                    case "время":
                        sendTextMessage(String.format("Информация для %s: %s", str[0], new SimpleDateFormat("H:mm:ss").format(Calendar.getInstance().getTime())));
                        break;
                    case "час":
                        sendTextMessage(String.format("Информация для %s: %s",str[0], new SimpleDateFormat("H").format(Calendar.getInstance().getTime())));
                        break;
                    case "минуты":
                        sendTextMessage(String.format("Информация для %s: %s", str[0], new SimpleDateFormat("m").format(Calendar.getInstance().getTime())));
                        break;
                    case "секунды":
                        sendTextMessage(String.format("Информация для %s: %s", str[0], new SimpleDateFormat("s").format(Calendar.getInstance().getTime())));
                        break;
                }
            }
        }
    }
}
