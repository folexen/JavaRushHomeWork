package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Flex on 29.12.2015.
 */
public class Server
{
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message)
    {
        for (Map.Entry<String, Connection> mapEntrySet: connectionMap.entrySet())
        {
            String clientName = mapEntrySet.getKey();
            Connection connection = mapEntrySet.getValue();
            try
            {
                connection.send(message);
            }
            catch (IOException ioException)
            {
                ConsoleHelper.writeMessage("Message to " + clientName + " wasn't delivered. Error occured.");
            }
        }
    }

    private static class Handler extends Thread
    {
        private Socket socket;

        public Handler(Socket socket)
        {
            this.socket = socket;
        }
        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException
        {
            while (true)
            {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message clientNameAnswer = connection.receive();
                if (clientNameAnswer.getType() == MessageType.USER_NAME)
                {
                    if (!clientNameAnswer.getData().isEmpty() && clientNameAnswer.getData() != null )
                    {
                        if (!connectionMap.containsKey(clientNameAnswer.getData()))
                        {
                            connectionMap.put(clientNameAnswer.getData(), connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return clientNameAnswer.getData();
                        }
                    }
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException
        {
            for (Map.Entry<String, Connection> connectionEntry : connectionMap.entrySet())
            {
                String activeUser = connectionEntry.getKey();
                if (!activeUser.equals(userName))
                {
                    connection.send(new Message(MessageType.USER_ADDED, activeUser));
                }
            }

        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException
        {
            while(true)
            {
                Message receivedMessage = connection.receive();
                if (receivedMessage.getType() == MessageType.TEXT)
                {
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + receivedMessage.getData()));
                } else
                {
                    ConsoleHelper.writeMessage("Message is not TEXT type. Error occured.");
                }
            }
        }

        public void run()
        {

            String clientName = null;
            try (Connection connection = new Connection(socket))
            {
                ConsoleHelper.writeMessage("Connection with server established through port " + socket.getRemoteSocketAddress() + ".");
                clientName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, clientName));
                sendListOfUsers(connection, clientName);
                serverMainLoop(connection, clientName);

            }
            catch (IOException exception)
            {
                ConsoleHelper.writeMessage("Error sending message");

            }
            catch (ClassNotFoundException exception2)
            {
                ConsoleHelper.writeMessage("Illegable message type found.");
            }
            if (clientName != null)
            {
                connectionMap.remove(clientName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, clientName));
            }
            ConsoleHelper.writeMessage("Server remote connection closed.");
        }
    }

    public static void main(String[] args)
    {
        ConsoleHelper.writeMessage("Enter server port....");
        int serverPort = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(serverPort))
        {
            ConsoleHelper.writeMessage("Server started.");
            while (true)
            {
                Handler handler = new Handler(serverSocket.accept());
                handler.start();
            }
        }
        catch (IOException ioException)
        {
            ConsoleHelper.writeMessage("Server error occured.");
        }
    }
}
