package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.*;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Flex on 11.01.2016.
 */
public class Client
{
    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAddress()
    {
        ConsoleHelper.writeMessage("Please enter server IP address...");
        ConsoleHelper.writeMessage("Hint:");
        ConsoleHelper.writeMessage("It could be 'localhost' for local machine.");
        String serverAddress = ConsoleHelper.readString();
        return serverAddress;
    }

    protected int getServerPort()
    {
        ConsoleHelper.writeMessage("Please enter server port...");
        int serverPort = ConsoleHelper.readInt();
        return serverPort;

    }

    protected String getUserName()
    {
        ConsoleHelper.writeMessage("Please enter your name...");
        String userName = ConsoleHelper.readString();
        return userName;
    }

    protected boolean shouldSentTextFromConsole()
    {
        return true;
    }

    protected SocketThread getSocketThread()
    {
        return new SocketThread();
    }

    protected void sendTextMessage(String text)
    {
        try
        {
            connection.send(new Message(MessageType.TEXT, text));
        }
        catch (IOException ex)
        {
            clientConnected = false;
        }
    }

    public void run()
    {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        try
        {
            synchronized (this)
            {
                this.wait();
            }
        }
        catch (InterruptedException e)
        {
            ConsoleHelper.writeMessage("Wait error");
            return;
        }
        if (clientConnected)
        {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        } else
        {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }
        String message;
        while (clientConnected)
        {
            if (!(message = ConsoleHelper.readString()).equalsIgnoreCase("exit"))
            {
                if (shouldSentTextFromConsole())
                {
                    sendTextMessage(message);
                }
            }
            else
            {
               return;
            }
        }
    }

    public static void main(String[] args)
    {
        Client client = new Client();
        client.run();
    }
    public class SocketThread extends Thread
    {
        protected void processIncomingMessage(String message)
        {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName)
        {
            ConsoleHelper.writeMessage(userName + " присоеденился к чату.");
        }

        protected void informAboutDeletingNewUser(String userName)
        {
            ConsoleHelper.writeMessage(userName + " покинул чат.");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected)
        {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this)
            {
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException
        {
            while (true)
            {
                Message message = connection.receive();
                if (message.getType() == MessageType.NAME_REQUEST)
                {
                    String userName = getUserName();
                    Message messageUserName = new Message(MessageType.USER_NAME, userName);
                    connection.send(messageUserName);
                }
                else if (message.getType() == MessageType.NAME_ACCEPTED)
                {
                    notifyConnectionStatusChanged(true);
                    return;
                }
                else
                {
                    throw new IOException("Unexpected MessageType");
                }

            }

        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {
            while (true)
            {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT)
                {
                    processIncomingMessage(message.getData());
                }
                else if (message.getType() == MessageType.USER_ADDED)
                {
                    informAboutAddingNewUser(message.getData());
                }
                else if (message.getType() == MessageType.USER_REMOVED)
                {
                    informAboutDeletingNewUser(message.getData());
                }
                else
                {
                    throw new IOException("Unexpected MessageType");
                }
            }

        }
        public void run()
        {
            try
            {
                String serverAddress = getServerAddress();
                int serverPort = getServerPort();
                Socket socket= new Socket(serverAddress, serverPort);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();

            }
            catch (IOException ex)
            {
                notifyConnectionStatusChanged(false);

            }
            catch (ClassNotFoundException ex1)
            {
                notifyConnectionStatusChanged(false);
            }
        }
    }
}
